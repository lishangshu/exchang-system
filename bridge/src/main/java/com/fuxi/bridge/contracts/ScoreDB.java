package com.fuxi.bridge.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.channel.event.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.FunctionEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Bool;
import org.fisco.bcos.web3j.abi.datatypes.Event;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int256;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class ScoreDB extends Contract {
    public static final String[] BINARY_ARRAY = {"608060405234801561001057600080fd5b506040516020806127118339810180604052810190808051906020019092919050505080336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505061264b806100c66000396000f3006080604052600436106100e6576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630ba8c23e146100eb57806313af4035146101385780631a7231ec1461017b57806326530f39146101e0578063541320981461024d57806384339c7c14610290578063889a37c6146102d3578063b2bdfa7b1461032e578063b76a517d14610385578063be835066146103dc578063bf604cf814610433578063c2ed077e1461045e578063ca3134f6146104b5578063d41711c3146104f8578063de56435d1461053b578063e5444a4214610588575b600080fd5b3480156100f757600080fd5b50610136600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506105df565b005b34801561014457600080fd5b50610179600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506108ce565b005b34801561018757600080fd5b506101c6600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610a53565b604051808215151515815260200191505060405180910390f35b3480156101ec57600080fd5b5061024b600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610ff4565b005b34801561025957600080fd5b5061028e600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611619565b005b34801561029c57600080fd5b506102d1600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506117cb565b005b3480156102df57600080fd5b50610314600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611951565b604051808215151515815260200191505060405180910390f35b34801561033a57600080fd5b50610343611d6c565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561039157600080fd5b5061039a611d91565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156103e857600080fd5b506103f1611db7565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561043f57600080fd5b50610448611ddd565b6040518082815260200191505060405180910390f35b34801561046a57600080fd5b50610473611de3565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156104c157600080fd5b506104f6600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611e09565b005b34801561050457600080fd5b50610539600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506120f0565b005b34801561054757600080fd5b50610586600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050612276565b005b34801561059457600080fd5b506105c9600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061256e565b6040518082815260200191505060405180910390f35b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614806106875750600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b1515610721576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001807f4261736963417574683a6f6e6c79206f776e6572206f722062616b206f776e6581526020017f7220697320617574686f72697a6564210000000000000000000000000000000081525060400191505060405180910390fd5b61072a826125ba565b151561079e576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260158152602001807f4163636f756e74206973206e6f7420657869737421000000000000000000000081525060200191505060405180910390fd5b80600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201819055507f70692fa2528b8a06caa460c45270c234b744498b7eb08604ad83a1e9d41e67003383836001604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018381526020018215151515815260200180602001828103825260158152602001807f4368616e6765206163636f756e742073746174757300000000000000000000008152506020019550505050505060405180910390a15050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614806109765750600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b1515610a10576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001807f4261736963417574683a6f6e6c79206f776e6572206f722062616b206f776e6581526020017f7220697320617574686f72697a6564210000000000000000000000000000000081525060400191505060405180910390fd5b806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161480610afd57506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b80610b555750600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b1515610bc9576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f4f6e6c79206175746865642063616e206f70657261746521000000000000000081525060200191505060405180910390fd5b610bd2836125ba565b15610f04577fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff600560008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201541415610c4a5760009050610fee565b816004600082825401925050819055508160056000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001016000828254039250508190555081600560008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101600082825401925050819055507fb49a155877721727b744e5ed8014264e0b1cd8e6a8533abe296773ac33630b4b3384846001604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183815260200182151515158152602001806020018281038252600f8152602001807f4d696e74616765207375636365737300000000000000000000000000000000008152506020019550505050505060405180910390a17f91a6d7baeea6a3cfa958d93002b0f9cae53567b7e754427149ded48200df10b483600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1684604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001806020018281038252600f8152602001807f5472616e6665722073756363657373000000000000000000000000000000000081525060200194505050505060405180910390a160019050610fee565b7fb49a155877721727b744e5ed8014264e0b1cd8e6a8533abe296773ac33630b4b3384846000604051808573ffffffffffffffffff","ffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183815260200182151515158152602001806020018281038252601a8152602001807f4163636f756e74206d61796265206e6f74206578697374efbc810000000000008152506020019550505050505060405180910390a1600090505b92915050565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16148061109c57506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b806110f45750600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b1515611168576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f4f6e6c79206175746865642063616e206f70657261746521000000000000000081525060200191505060405180910390fd5b8173ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff161415151561120c576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601e8152602001807f596f752063616e2774207472616e66657220746f20796f757273656c6621000081525060200191505060405180910390fd5b611215836125ba565b80156112265750611225826125ba565b5b151561129a576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601c8152602001807f48617665204163636f756e747320617265206e6f74206578697374210000000081525060200191505060405180910390fd5b80600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001015410151515611354576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601e8152602001807f4f75742061646472657373206c61636b206f662062616c616e6365efbc81000081525060200191505060405180910390fd5b7fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff600560008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201541415801561142857507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206002015414155b151561149c576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260158152602001807f4861766520696e76616c6964204163636f756e7421000000000000000000000081525060200191505060405180910390fd5b80600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001016000828254039250508190555080600560008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101600082825401925050819055507f91a6d7baeea6a3cfa958d93002b0f9cae53567b7e754427149ded48200df10b4838383604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200180602001828103825260108152602001807f5472616e6665722073756363657373210000000000000000000000000000000081525060200194505050505060405180910390a1505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614806116c15750600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b151561175b576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260368152602001807f4f6e6c79206f776e657220616e642062616b4f776e65722063616e206368616e81526020017f6765207468652073797374656d206163636f756e74210000000000000000000081525060400191505060405180910390fd5b80600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506117c7600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16611951565b5050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614806118735750600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b151561190d576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001807f4261736963417574683a6f6e6c79206f776e6572206f722062616b206f776e6581526020017f7220697320617574686f72697a6564210000000000000000000000000000000081525060400191505060405180910390fd5b80600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614806119fb57506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b80611a535750600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b1515611ac7576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f4f6e6c79206175746865642063616e206f70657261746521000000000000000081525060200191505060405180910390fd5b611ad0826125ba565b1515611c855781600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506001600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201819055507f0ba5ad7d9bea0f41025dc6a539c8f9b3a88473cdac38e5be32d5768388ae51f033836001604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807f526567697374657220737563636573736564efbc81000000000000000000000081525060200194505050505060405180910390a160019050611d67565b7f0ba5ad7d9bea0f41025dc6a539c8f9b3a88473cdac38e5be32d5768388ae51f033836000604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252601b8152602001807f54686973206163636f756e74206861732065786973746564efbc81000000000081525060200194505050505060405180910390a1600090505b919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60045481565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161480611eb15750600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b1515611f4b576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001807f4261736963417574683a6f6e6c79206f776e6572206f722062616b206f776e6581526020017f7220697320617574686f72697a65642100000000000000000000000000000000","81525060400191505060405180910390fd5b611f54816125ba565b1515611fc8576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260158152602001807f4163636f756e74206973206e6f7420657869737421000000000000000000000081525060200191505060405180910390fd5b6000600560008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101819055507fc9c85be334afbe3cef6c64dc6f0b6c1c53151c4208ef08510e7795026f5a0c2233826001604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252601d8152602001807f5265736574206163636f756e7420616d6f756e7420737563636573732100000081525060200194505050505060405180910390a150565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614806121985750600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b1515612232576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602f8152602001807f4f6e6c79206f776e657220616e642062616b4f776e65722063616e206368616e81526020017f6765207468652076657273696f6e21000000000000000000000000000000000081525060400191505060405180910390fd5b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16148061231e5750600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b15156123b8576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001807f4261736963417574683a6f6e6c79206f776e6572206f722062616b206f776e6581526020017f7220697320617574686f72697a6564210000000000000000000000000000000081525060400191505060405180910390fd5b6123c1826125ba565b1515612435576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260158152602001807f4163636f756e74206973206e6f7420657869737421000000000000000000000081525060200191505060405180910390fd5b80600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101600082825401925050819055507f4d5d1dd77d43ac56f6123aebec42f07500c66a59303c3f2e7980fb8b8dd08cc33383836001604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018381526020018215151515815260200180602001828103825260178152602001807f4163636f756e7420686173206164642073636f726573210000000000000000008152506020019550505050505060405180910390a15050565b6000600560008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101549050919050565b600080600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020154905060008114156126145760009150612619565b600191505b509190505600a165627a7a72305820f839d52abb857c4a7e4b6bfcae7f09be50b58edbc7adba255c00231783734c840029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"adder\",\"type\":\"address\"},{\"name\":\"status\",\"type\":\"int256\"}],\"name\":\"changeAccountStatus\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"owner\",\"type\":\"address\"}],\"name\":\"setOwner\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_customerAddr\",\"type\":\"address\"},{\"name\":\"amount\",\"type\":\"uint256\"}],\"name\":\"mintageIncome\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"inAdder\",\"type\":\"address\"},{\"name\":\"outAdder\",\"type\":\"address\"},{\"name\":\"amount\",\"type\":\"uint256\"}],\"name\":\"tranfer\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"newSystemAccount\",\"type\":\"address\"}],\"name\":\"setSystemAccount\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"owner\",\"type\":\"address\"}],\"name\":\"setBakOwner\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_customerAddr\",\"type\":\"address\"}],\"name\":\"newCustomer\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"_owner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"_latestVersion\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"_bakOwner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"_mintageAmount\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"_systemAccount\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"adder\",\"type\":\"address\"}],\"name\":\"resetAccount\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"newVersion\",\"type\":\"address\"}],\"name\":\"upgradeVerion\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"dst\",\"type\":\"address\"},{\"name\":\"amount\",\"type\":\"uint256\"}],\"name\":\"addScoreToAccount\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"adder\",\"type\":\"address\"}],\"name\":\"getMyScore\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"bakOwner\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"operator\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"inAdder\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"isSuccess\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"_NewCustomer\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"operator\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"_customerAddr\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"amount\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"isSuccesss\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"_MintageCoin\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"inAdder\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"outAdder\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"amount\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"_Tranfer\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"operator\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"dst\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"isSuccesss\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"_ResetAccount\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"operator\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"dst\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"status\",\"type\":\"int256\"},{\"indexed\":false,\"name\":\"isSuccesss\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"_ChangeAccountStatus\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"operator\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"dst\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"amount\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"isSuccess\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"_AddScoreToAccount\",\"type\":\"event\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_CHANGEACCOUNTSTATUS = "changeAccountStatus";

    public static final String FUNC_SETOWNER = "setOwner";

    public static final String FUNC_MINTAGEINCOME = "mintageIncome";

    public static final String FUNC_TRANFER = "tranfer";

    public static final String FUNC_SETSYSTEMACCOUNT = "setSystemAccount";

    public static final String FUNC_SETBAKOWNER = "setBakOwner";

    public static final String FUNC_NEWCUSTOMER = "newCustomer";

    public static final String FUNC__OWNER = "_owner";

    public static final String FUNC__LATESTVERSION = "_latestVersion";

    public static final String FUNC__BAKOWNER = "_bakOwner";

    public static final String FUNC__MINTAGEAMOUNT = "_mintageAmount";

    public static final String FUNC__SYSTEMACCOUNT = "_systemAccount";

    public static final String FUNC_RESETACCOUNT = "resetAccount";

    public static final String FUNC_UPGRADEVERION = "upgradeVerion";

    public static final String FUNC_ADDSCORETOACCOUNT = "addScoreToAccount";

    public static final String FUNC_GETMYSCORE = "getMyScore";

    public static final Event _NEWCUSTOMER_EVENT = new Event("_NewCustomer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event _MINTAGECOIN_EVENT = new Event("_MintageCoin", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event _TRANFER_EVENT = new Event("_Tranfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event _RESETACCOUNT_EVENT = new Event("_ResetAccount", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event _CHANGEACCOUNTSTATUS_EVENT = new Event("_ChangeAccountStatus", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Int256>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event _ADDSCORETOACCOUNT_EVENT = new Event("_AddScoreToAccount", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
    ;

    @Deprecated
    protected ScoreDB(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ScoreDB(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ScoreDB(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ScoreDB(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> changeAccountStatus(String adder, BigInteger status) {
        final Function function = new Function(
                FUNC_CHANGEACCOUNTSTATUS, 
                Arrays.<Type>asList(new Address(adder),
                new Int256(status)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void changeAccountStatus(String adder, BigInteger status, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CHANGEACCOUNTSTATUS, 
                Arrays.<Type>asList(new Address(adder),
                new Int256(status)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String changeAccountStatusSeq(String adder, BigInteger status) {
        final Function function = new Function(
                FUNC_CHANGEACCOUNTSTATUS, 
                Arrays.<Type>asList(new Address(adder),
                new Int256(status)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getChangeAccountStatusInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_CHANGEACCOUNTSTATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setOwner(String owner) {
        final Function function = new Function(
                FUNC_SETOWNER, 
                Arrays.<Type>asList(new Address(owner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setOwner(String owner, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETOWNER, 
                Arrays.<Type>asList(new Address(owner)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setOwnerSeq(String owner) {
        final Function function = new Function(
                FUNC_SETOWNER, 
                Arrays.<Type>asList(new Address(owner)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getSetOwnerInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> mintageIncome(String _customerAddr, BigInteger amount) {
        final Function function = new Function(
                FUNC_MINTAGEINCOME, 
                Arrays.<Type>asList(new Address(_customerAddr),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void mintageIncome(String _customerAddr, BigInteger amount, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_MINTAGEINCOME, 
                Arrays.<Type>asList(new Address(_customerAddr),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String mintageIncomeSeq(String _customerAddr, BigInteger amount) {
        final Function function = new Function(
                FUNC_MINTAGEINCOME, 
                Arrays.<Type>asList(new Address(_customerAddr),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getMintageIncomeInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_MINTAGEINCOME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public Tuple1<Boolean> getMintageIncomeOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_MINTAGEINCOME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<Boolean>(

                (Boolean) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> tranfer(String inAdder, String outAdder, BigInteger amount) {
        final Function function = new Function(
                FUNC_TRANFER, 
                Arrays.<Type>asList(new Address(inAdder),
                new Address(outAdder),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void tranfer(String inAdder, String outAdder, BigInteger amount, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_TRANFER, 
                Arrays.<Type>asList(new Address(inAdder),
                new Address(outAdder),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String tranferSeq(String inAdder, String outAdder, BigInteger amount) {
        final Function function = new Function(
                FUNC_TRANFER, 
                Arrays.<Type>asList(new Address(inAdder),
                new Address(outAdder),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<String, String, BigInteger> getTranferInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_TRANFER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple3<String, String, BigInteger>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue(), 
                (BigInteger) results.get(2).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setSystemAccount(String newSystemAccount) {
        final Function function = new Function(
                FUNC_SETSYSTEMACCOUNT, 
                Arrays.<Type>asList(new Address(newSystemAccount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setSystemAccount(String newSystemAccount, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETSYSTEMACCOUNT, 
                Arrays.<Type>asList(new Address(newSystemAccount)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setSystemAccountSeq(String newSystemAccount) {
        final Function function = new Function(
                FUNC_SETSYSTEMACCOUNT, 
                Arrays.<Type>asList(new Address(newSystemAccount)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getSetSystemAccountInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETSYSTEMACCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setBakOwner(String owner) {
        final Function function = new Function(
                FUNC_SETBAKOWNER, 
                Arrays.<Type>asList(new Address(owner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setBakOwner(String owner, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETBAKOWNER, 
                Arrays.<Type>asList(new Address(owner)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setBakOwnerSeq(String owner) {
        final Function function = new Function(
                FUNC_SETBAKOWNER, 
                Arrays.<Type>asList(new Address(owner)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getSetBakOwnerInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETBAKOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> newCustomer(String _customerAddr) {
        final Function function = new Function(
                FUNC_NEWCUSTOMER, 
                Arrays.<Type>asList(new Address(_customerAddr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void newCustomer(String _customerAddr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_NEWCUSTOMER, 
                Arrays.<Type>asList(new Address(_customerAddr)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String newCustomerSeq(String _customerAddr) {
        final Function function = new Function(
                FUNC_NEWCUSTOMER, 
                Arrays.<Type>asList(new Address(_customerAddr)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getNewCustomerInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_NEWCUSTOMER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public Tuple1<Boolean> getNewCustomerOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_NEWCUSTOMER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<Boolean>(

                (Boolean) results.get(0).getValue()
                );
    }

    public RemoteCall<String> _owner() {
        final Function function = new Function(FUNC__OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> _latestVersion() {
        final Function function = new Function(FUNC__LATESTVERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> _bakOwner() {
        final Function function = new Function(FUNC__BAKOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> _mintageAmount() {
        final Function function = new Function(FUNC__MINTAGEAMOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> _systemAccount() {
        final Function function = new Function(FUNC__SYSTEMACCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> resetAccount(String adder) {
        final Function function = new Function(
                FUNC_RESETACCOUNT, 
                Arrays.<Type>asList(new Address(adder)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void resetAccount(String adder, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_RESETACCOUNT, 
                Arrays.<Type>asList(new Address(adder)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String resetAccountSeq(String adder) {
        final Function function = new Function(
                FUNC_RESETACCOUNT, 
                Arrays.<Type>asList(new Address(adder)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getResetAccountInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_RESETACCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> upgradeVerion(String newVersion) {
        final Function function = new Function(
                FUNC_UPGRADEVERION, 
                Arrays.<Type>asList(new Address(newVersion)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void upgradeVerion(String newVersion, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_UPGRADEVERION, 
                Arrays.<Type>asList(new Address(newVersion)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String upgradeVerionSeq(String newVersion) {
        final Function function = new Function(
                FUNC_UPGRADEVERION, 
                Arrays.<Type>asList(new Address(newVersion)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getUpgradeVerionInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_UPGRADEVERION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> addScoreToAccount(String dst, BigInteger amount) {
        final Function function = new Function(
                FUNC_ADDSCORETOACCOUNT, 
                Arrays.<Type>asList(new Address(dst),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void addScoreToAccount(String dst, BigInteger amount, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ADDSCORETOACCOUNT, 
                Arrays.<Type>asList(new Address(dst),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String addScoreToAccountSeq(String dst, BigInteger amount) {
        final Function function = new Function(
                FUNC_ADDSCORETOACCOUNT, 
                Arrays.<Type>asList(new Address(dst),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getAddScoreToAccountInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ADDSCORETOACCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> getMyScore(String adder) {
        final Function function = new Function(
                FUNC_GETMYSCORE, 
                Arrays.<Type>asList(new Address(adder)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void getMyScore(String adder, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_GETMYSCORE, 
                Arrays.<Type>asList(new Address(adder)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String getMyScoreSeq(String adder) {
        final Function function = new Function(
                FUNC_GETMYSCORE, 
                Arrays.<Type>asList(new Address(adder)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getGetMyScoreInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_GETMYSCORE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public Tuple1<BigInteger> getGetMyScoreOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_GETMYSCORE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public List<_NewCustomerEventResponse> get_NewCustomerEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(_NEWCUSTOMER_EVENT, transactionReceipt);
        ArrayList<_NewCustomerEventResponse> responses = new ArrayList<_NewCustomerEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            _NewCustomerEventResponse typedResponse = new _NewCustomerEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.inAdder = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.isSuccess = (Boolean) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void register_NewCustomerEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_NEWCUSTOMER_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void register_NewCustomerEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_NEWCUSTOMER_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<_MintageCoinEventResponse> get_MintageCoinEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(_MINTAGECOIN_EVENT, transactionReceipt);
        ArrayList<_MintageCoinEventResponse> responses = new ArrayList<_MintageCoinEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            _MintageCoinEventResponse typedResponse = new _MintageCoinEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._customerAddr = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.isSuccesss = (Boolean) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void register_MintageCoinEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_MINTAGECOIN_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void register_MintageCoinEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_MINTAGECOIN_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<_TranferEventResponse> get_TranferEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(_TRANFER_EVENT, transactionReceipt);
        ArrayList<_TranferEventResponse> responses = new ArrayList<_TranferEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            _TranferEventResponse typedResponse = new _TranferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.inAdder = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.outAdder = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void register_TranferEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_TRANFER_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void register_TranferEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_TRANFER_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<_ResetAccountEventResponse> get_ResetAccountEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(_RESETACCOUNT_EVENT, transactionReceipt);
        ArrayList<_ResetAccountEventResponse> responses = new ArrayList<_ResetAccountEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            _ResetAccountEventResponse typedResponse = new _ResetAccountEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.dst = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.isSuccesss = (Boolean) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void register_ResetAccountEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_RESETACCOUNT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void register_ResetAccountEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_RESETACCOUNT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<_ChangeAccountStatusEventResponse> get_ChangeAccountStatusEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(_CHANGEACCOUNTSTATUS_EVENT, transactionReceipt);
        ArrayList<_ChangeAccountStatusEventResponse> responses = new ArrayList<_ChangeAccountStatusEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            _ChangeAccountStatusEventResponse typedResponse = new _ChangeAccountStatusEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.dst = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.status = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.isSuccesss = (Boolean) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void register_ChangeAccountStatusEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_CHANGEACCOUNTSTATUS_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void register_ChangeAccountStatusEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_CHANGEACCOUNTSTATUS_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<_AddScoreToAccountEventResponse> get_AddScoreToAccountEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(_ADDSCORETOACCOUNT_EVENT, transactionReceipt);
        ArrayList<_AddScoreToAccountEventResponse> responses = new ArrayList<_AddScoreToAccountEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            _AddScoreToAccountEventResponse typedResponse = new _AddScoreToAccountEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.dst = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.isSuccess = (Boolean) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void register_AddScoreToAccountEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_ADDSCORETOACCOUNT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void register_AddScoreToAccountEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_ADDSCORETOACCOUNT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    @Deprecated
    public static ScoreDB load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ScoreDB(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ScoreDB load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ScoreDB(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ScoreDB load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ScoreDB(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ScoreDB load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ScoreDB(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ScoreDB> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String bakOwner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(bakOwner)));
        return deployRemoteCall(ScoreDB.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ScoreDB> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String bakOwner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(bakOwner)));
        return deployRemoteCall(ScoreDB.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ScoreDB> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String bakOwner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(bakOwner)));
        return deployRemoteCall(ScoreDB.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ScoreDB> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String bakOwner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(bakOwner)));
        return deployRemoteCall(ScoreDB.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class _NewCustomerEventResponse {
        public Log log;

        public String operator;

        public String inAdder;

        public Boolean isSuccess;

        public String message;
    }

    public static class _MintageCoinEventResponse {
        public Log log;

        public String operator;

        public String _customerAddr;

        public BigInteger amount;

        public Boolean isSuccesss;

        public String message;
    }

    public static class _TranferEventResponse {
        public Log log;

        public String inAdder;

        public String outAdder;

        public BigInteger amount;

        public String message;
    }

    public static class _ResetAccountEventResponse {
        public Log log;

        public String operator;

        public String dst;

        public Boolean isSuccesss;

        public String message;
    }

    public static class _ChangeAccountStatusEventResponse {
        public Log log;

        public String operator;

        public String dst;

        public BigInteger status;

        public Boolean isSuccesss;

        public String message;
    }

    public static class _AddScoreToAccountEventResponse {
        public Log log;

        public String operator;

        public String dst;

        public BigInteger amount;

        public Boolean isSuccess;

        public String message;
    }
}
