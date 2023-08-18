package com.afiab.scaffolding.server.service.convert;


import com.afiab.scaffolding.api.dto.request.StuReqDTO;
import com.afiab.scaffolding.api.dto.response.StuRespDTO;
import com.afiab.scaffolding.dao.entity.StuPO;
import com.afiab.scaffolding.server.service.convert.qualifier.ExtendMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 15:32
 * @Description:
 */
@Mapper(componentModel = "spring", uses = ExtendMapper.class)
public interface StuConvert {
    StuConvert INS = Mappers.getMapper(StuConvert.class);

    // 入参转实体
    StuPO convert(StuReqDTO reqDTO);
    // 实体转出参
    @Mappings({
            @Mapping(target = "stuJson", source = "po", qualifiedByName = {"translatorStr"}),
    })
    StuRespDTO convertResp(StuPO po);

    List<StuPO> convertPOs(List<StuReqDTO> pos);


    List<StuRespDTO> convertResps(List<StuPO> pos);
}
