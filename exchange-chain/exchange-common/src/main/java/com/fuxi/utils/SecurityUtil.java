package com.fuxi.utils;

import com.sun.jersey.core.util.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Enumeration;
import java.util.Random;

/**
 * 本类是本安全包的主类，负责提供公开的静态的方法供其它模块调用，采用BouncyCastleProvider 功能如下： 1）MD5，SHA-1摘要
 * 
 * 序号 时间 作者 修改内容 1. 2009-12-14 duyujun created this class.
 */
public class SecurityUtil {

	/**
	 * 执行初始化操作，将 BouncyCastleProvider添加到java.security.Security中
	 */

	static {
		Security.addProvider(new BouncyCastleProvider());
	}

	private SecurityUtil() {
	}

	/**
	 * 对数据做MD5摘要
	 * 
	 * @param aData
	 *            源数据
	 * @return 摘要结果
	 * @throws SecurityException
	 * @author nilomiao
	 * @since 2009-11-27
	 */
	public static String MD5Encode(String aData) throws SecurityException {
		String resultString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = bytes2HexString(md.digest(aData.getBytes("UTF-8")));
		} catch (Exception e) {
			e.printStackTrace();
			throw new SecurityException("MD5运算失败");
		}
		return resultString;
	}

	public static String bytes2HexString(byte[] b) {
		String ret = "";
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			ret += hex.toUpperCase();
		}
		return ret;
	}

	public static String encrypt(String answer1) throws Exception {
		Security
				.addProvider(new BouncyCastleProvider());
		byte[] tEncData = SecurityUtil.encryptByPassword("PBEWithMD5AndDES",
				"allinpay-ets".toCharArray(), answer1.getBytes());
		return base64Encode(tEncData);
	}

    /**
     *
     * @param strEncrypt
     * @return
     */
	public static String decrypt(String strEncrypt) {
		Security
				.addProvider(new BouncyCastleProvider());
		byte[] answer2 = SecurityUtil.base64Decode(strEncrypt);
		byte[] answer3 = SecurityUtil.decryptByPassword("PBEWithMD5AndDES",
				"allinpay-ets".toCharArray(), answer2);
		return new String(answer3);
	}

	public static String base64Encode(byte[] aSourceData) {
		return new BASE64Encoder().encode(aSourceData);
	}

	public static byte[] base64Decode(String aSourceData) {
		try {
			byte[] tResult = new BASE64Decoder().decodeBuffer(aSourceData);
			return tResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] encryptByPassword(String aMethod, char[] aPassword,
			byte[] aSourceData) {
		try {
			Random tRandom = new Random();

			byte[] tSalt = new byte[8];
			tRandom.nextBytes(tSalt);

			PBEKeySpec tPBEKeySpec = new PBEKeySpec(aPassword);
			SecretKeyFactory tKeyFactory = SecretKeyFactory
					.getInstance(aMethod);
			SecretKey tKey = tKeyFactory.generateSecret(tPBEKeySpec);

			PBEParameterSpec tParamSpec = new PBEParameterSpec(tSalt, 100);
			Cipher tCipher = Cipher.getInstance(aMethod);
			tCipher.init(1, tKey, tParamSpec);

			byte[] tCipherText = tCipher.doFinal(aSourceData);

			byte[] tResult = new byte[tSalt.length + tCipherText.length];
			for (int i = 0; i < tSalt.length; ++i) {
				tResult[i] = tSalt[i];
			}
			for (int i = 0; i < tCipherText.length; ++i) {
				tResult[(i + tSalt.length)] = tCipherText[i];
			}

			return tResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] decryptByPassword(String aMethod, char[] aPassword,
			byte[] aSourceData) {
		try {
			byte[] tSalt = new byte[8];
			byte[] tCipherText = new byte[aSourceData.length - 8];

			for (int i = 0; i < tSalt.length; ++i) {
				tSalt[i] = aSourceData[i];
			}
			for (int i = 0; i < tCipherText.length; ++i) {
				tCipherText[i] = aSourceData[(i + tSalt.length)];
			}

			PBEKeySpec tPBEKeySpec = new PBEKeySpec(aPassword);
			SecretKeyFactory tKeyFactory = SecretKeyFactory
					.getInstance(aMethod);
			SecretKey tKey = tKeyFactory.generateSecret(tPBEKeySpec);

			PBEParameterSpec tParamSpec = new PBEParameterSpec(tSalt, 100);
			Cipher tCipher = Cipher.getInstance(aMethod);
			tCipher.init(2, tKey, tParamSpec);

			byte[] tResult = tCipher.doFinal(tCipherText);

			return tResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] sign(String aMethod, byte[] aCertificate,
			char[] aPassword, byte[] aSourceData) {
		try {
			String tAlias = new String();

			KeyStore tKeystore = KeyStore.getInstance("PKCS12");
			tKeystore.load(new ByteArrayInputStream(aCertificate), aPassword);

			Enumeration e = tKeystore.aliases();
			if (e.hasMoreElements()) {
				tAlias = (String) e.nextElement();
			}
			PrivateKey tPrivateKey = (PrivateKey) tKeystore.getKey(tAlias,
					aPassword);

			Signature tSign = Signature.getInstance(aMethod);
			tSign.initSign(tPrivateKey);

			tSign.update(aSourceData);
			byte[] tSignedText = tSign.sign();

			return tSignedText;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean verify(String aMethod, byte[] aCertificate,
			byte[] aPlainData, byte[] aSignature) {
		boolean tResult = false;
		try {
			CertificateFactory tCertFactory = CertificateFactory
					.getInstance("X.509");
			Certificate tCertificate = tCertFactory
					.generateCertificate(new ByteArrayInputStream(aCertificate));

			Signature tSign = Signature.getInstance(aMethod);
			tSign.initVerify(tCertificate);

			tSign.update(aPlainData);
			tResult = tSign.verify(aSignature);

			return tResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean verifyByRSA(String certPath, byte[] aPlainData,
			byte[] aSignature) {
		boolean tResult = false;
		try {
			InputStream inStream = new FileInputStream(certPath);
			CertificateFactory tCertFactory = CertificateFactory
					.getInstance("X.509");
			Certificate tCertificate = tCertFactory
					.generateCertificate(inStream);

			Signature tSign = Signature.getInstance("SHA1withRSA", "BC");
			tSign.initVerify(tCertificate);

			tSign.update(aPlainData);
			tResult = tSign.verify(aSignature);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tResult;
	}

	public static byte[] getSymmetricKey(String aMethod, char[] aPassword) {
		try {
			KeyGenerator tKeyGen = KeyGenerator.getInstance(aMethod);
			if (aMethod.equalsIgnoreCase("DESede"))
				tKeyGen.init(192);
			else {
				tKeyGen.init(56);
			}
			Key tKey = tKeyGen.generateKey();

			byte[] tKeyBytes = tKey.getEncoded();
			byte[] tEncKeyBytes = encryptByPassword("PBEWithSHAAndTwofish-CBC",
					aPassword, tKeyBytes);

			return tEncKeyBytes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] encryptByKey(String aMethod, byte[] aKey,
			char[] aPassword, byte[] aSourceData) {
		try {
			byte[] tKeyBytes = decryptByPassword("PBEWithSHAAndTwofish-CBC",
					aPassword, aKey);
			SecretKeySpec tKeySpec = new SecretKeySpec(tKeyBytes, aMethod);

			Cipher tCipher = Cipher.getInstance(aMethod);
			tCipher.init(1, tKeySpec);

			return tCipher.doFinal(aSourceData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] decryptByKey(String aMethod, byte[] aKey,
			char[] aPassword, byte[] aSourceData) {
		try {
			byte[] tKeyBytes = decryptByPassword("PBEWithSHAAndTwofish-CBC",
					aPassword, aKey);
			SecretKeySpec tKeySpec = new SecretKeySpec(tKeyBytes, aMethod);

			Cipher tCipher = Cipher.getInstance(aMethod);
			tCipher.init(2, tKeySpec);

			return tCipher.doFinal(aSourceData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    /**
     *  RSA加密算法
     * @param certPath
     * @param plainText
     * @return
     * @throws SecurityException
     */
	public static String encryptByPublicKey(String certPath, String plainText) throws SecurityException {
		try {
			InputStream inStream = new FileInputStream(certPath);
			CertificateFactory tCertFactory = CertificateFactory
					.getInstance("X.509");
			Certificate tCertificate = tCertFactory
					.generateCertificate(inStream);

			// 获得一个RSA的Cipher类，使用公钥加密
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding"); // /ECB/PKCS1Padding");

			// Cipher.ENCRYPT_MODE意思是加密，从一对钥匙中得到公钥key.getPublic()
			cipher.init(Cipher.ENCRYPT_MODE, tCertificate.getPublicKey());

			// 用公钥进行加密，返回一个字节流
			byte[] cipherText = cipher.doFinal(plainText.getBytes());
			
			// Base64编码
			return new String(Base64.encode(cipherText));

		} catch (Exception e) {
			throw new SecurityException("使用公钥加密失败：" + e.getMessage());
		}
	}

	/**
	 * 从文件中输入流中加载公钥
	 *
	 * @param path
	 *            公钥输入流
	 * @throws Exception
	 *             加载公钥时产生的异常
	 */
	public static String loadPublicKeyByFile(String path) throws Exception {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String readLine = null;
			StringBuilder sb = new StringBuilder();
			while ((readLine = br.readLine()) != null) {
                if (readLine.charAt(0) == '-')
                {
                    continue;
                } else
                {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
			br.close();
			return sb.toString();
		} catch (IOException e) {
			throw new Exception("公钥数据流读取错误");
		} catch (NullPointerException e) {
			throw new Exception("公钥输入流为空");
		}
	}


    /**
     *  使用公钥加密
     * @param plainText
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey2(String plainText, String publicKey)
            throws Exception {
        try{
        byte[] keyBytes = Base64.decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey1 = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        // 获得一个RSA的Cipher类，使用公钥加密
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING"); // /ECB/PKCS1Padding");

        // Cipher.ENCRYPT_MODE意思是加密，从一对钥匙中得到公钥key.getPublic()
        cipher.init(Cipher.ENCRYPT_MODE, publicKey1);

        // 用公钥进行加密，返回一个字节流
        byte[] cipherText = cipher.doFinal(plainText.getBytes());

        // Base64编码
        return new String(Base64.encode(cipherText));
    } catch (Exception e) {
        throw new SecurityException("使用公钥加密失败：" + e.getMessage());
    }
    }

}
