package com.arextest.web.model.contract.contracts.config.replay;


import com.arextest.web.model.contract.contracts.common.enums.ExpirationType;
import com.arextest.web.model.contract.contracts.config.AbstractConfiguration;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class AbstractComparisonDetailsConfiguration extends AbstractConfiguration {

    private String id;

    /**
     * optional
     * if empty should be apply to all appIds replay compare,means global default
     */
    private String appId;

    /**
     * optional
     * The value limit to special operation should be used, else,couldn't apply for it.
     * empty,means is unlimited.
     */
    private String operationId;

    /**
     * the value from {@link ExpirationType} indicate which type should be used.
     */
    private int expirationType;
    private Date expirationDate;

    /**
     * the source of the configuration.
     * 0 = from arex record
     * 1 = from collections
     */
    private int compareConfigType;

    /**
     * This value is valid only when {compareConfigType} = 1
     */
    private String fsInterfaceId;

}
