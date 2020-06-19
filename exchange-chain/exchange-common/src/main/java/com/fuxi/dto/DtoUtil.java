package com.fuxi.dto;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fuxi.constant.CodeConst;
import com.fuxi.utils.DateUtil;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
@Slf4j
public class DtoUtil {
	
	public static ResultDto convert(DataTransferObject<? extends Object> dto) {
		ResultDto rd = new ResultDto();
		
		Map<String, Object> head = Maps.newHashMap();
		Map<String, Object> body = Maps.newHashMap();
		head.put("status", dto.getCode());
		head.put("fetchDate", DateUtil.getServiceCurrentTime());
		rd.setHead(head);
		
		if(CodeConst.SUCCESS_CODE.equals(dto.getCode())) {
			if(dto.getData() != null) {
				rd.setBody(dto.getData());
			} else {
				if (StringUtils.isNotBlank(dto.getMsg())) {
					body.put("msg", dto.getMsg());
				}
				rd.setBody(body);
			}
		} else {
			body.put("msg", dto.getMsg());
			rd.setBody(body);
		}
		log.info("【响应信息】==>{}",JSONObject.toJSON(rd));
		return rd;
	}
	
}
