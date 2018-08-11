package com.viettel.api.dto.qldv;

import com.viettel.api.domain.qldv.PartnerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
public class PartnerDto {
    private Long partnerId;
    private String partnerCode;
    private String partnerName;
    private String partnerType;
    private String createUser;
    private Timestamp createDate;
    private String updateUser;
    private Timestamp updateDate;
    private String status;

    public PartnerDto() {
    }

    public PartnerEntity toEntity() {
        Logger logger = LoggerFactory.getLogger(PartnerDto.class);
        try {
            PartnerEntity entity = new PartnerEntity(
                    partnerId,
                    partnerCode,
                    partnerName,
                    partnerType,
                    createUser,
                    createDate,
                    updateUser,
                    updateDate,
                    status
            );
            return entity;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
