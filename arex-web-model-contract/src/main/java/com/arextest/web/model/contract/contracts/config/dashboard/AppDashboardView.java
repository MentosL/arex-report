package com.arextest.web.model.contract.contracts.config.dashboard;

import com.arextest.web.model.contract.contracts.config.application.ApplicationDescription;
import lombok.Data;

/**
 * @author jmo
 * @since 2022/1/21
 */
@Data
public class AppDashboardView {
    private ApplicationDescription applicationDescription;
    private int operationCount;
}
