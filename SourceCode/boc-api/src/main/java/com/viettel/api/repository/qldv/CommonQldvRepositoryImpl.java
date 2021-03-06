package com.viettel.api.repository.qldv;

import com.viettel.api.dto.qldv.CodeDecodeDto;
import com.viettel.api.repository.BaseRepository;
import com.viettel.api.utils.SQLBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
@Repository
@Transactional
public class CommonQldvRepositoryImpl extends BaseRepository implements CommonQldvRepository {

    Logger logger = LoggerFactory.getLogger(CommonQldvRepositoryImpl.class);

    @Override
    public List<CodeDecodeDto> search(CodeDecodeDto dto) {
        List<CodeDecodeDto> list = new ArrayList<>();
        try {
            String sql = SQLBuilder.getSqlQueryById(SQLBuilder.SQL_MODULE_QLDV_COMMON, "search_by_code_group");
            Map<String, String> maps = new HashMap<>();
            maps.put("p_group_list", dto.getCodeGroup());
            list = getNamedParameterJdbcTemplate().query(sql, maps, BeanPropertyRowMapper.newInstance(CodeDecodeDto.class));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return list;
    }
}
