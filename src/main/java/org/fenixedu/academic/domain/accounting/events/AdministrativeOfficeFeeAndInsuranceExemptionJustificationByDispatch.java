/**
 * Copyright © 2002 Instituto Superior Técnico
 *
 * This file is part of FenixEdu Academic.
 *
 * FenixEdu Academic is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * FenixEdu Academic is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with FenixEdu Academic.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.fenixedu.academic.domain.accounting.events;

import org.apache.commons.lang.StringUtils;
import org.fenixedu.academic.domain.accounting.Exemption;
import org.fenixedu.academic.domain.exceptions.DomainException;
import org.fenixedu.academic.domain.exceptions.DomainExceptionWithLabelFormatter;
import org.fenixedu.academic.util.Bundle;
import org.fenixedu.academic.util.LabelFormatter;
import org.joda.time.YearMonthDay;

public class AdministrativeOfficeFeeAndInsuranceExemptionJustificationByDispatch extends
        AdministrativeOfficeFeeAndInsuranceExemptionJustificationByDispatch_Base {

    protected AdministrativeOfficeFeeAndInsuranceExemptionJustificationByDispatch() {
        super();
    }

    public AdministrativeOfficeFeeAndInsuranceExemptionJustificationByDispatch(final Exemption exemption,
            final AdministrativeOfficeFeeAndInsuranceExemptionJustificationType justificationType, final String reason,
            final YearMonthDay dispatchDate) {
        this();
        init(exemption, justificationType, reason, dispatchDate);

    }

    private void init(Exemption exemption, AdministrativeOfficeFeeAndInsuranceExemptionJustificationType justificationType,
            String reason, YearMonthDay dispatchDate) {
        checkParameters(exemption, justificationType, reason, dispatchDate);

        super.init(exemption, justificationType, reason);

        super.setDispatchDate(dispatchDate);

    }

    private void checkParameters(Exemption exemption,
            AdministrativeOfficeFeeAndInsuranceExemptionJustificationType justificationType, String reason,
            YearMonthDay dispatchDate) {

        if (!exemption.isForAdministrativeOfficeFee()) {
            throw new DomainException(
                    "error.accounting.events.AdministrativeOfficeFeeAndInsuranceExemptionJustificationByDispatch.exemption.must.be.form.administrativeOfficeFee.exemption");
        }

        if (dispatchDate == null || StringUtils.isEmpty(reason)) {
            throw new DomainExceptionWithLabelFormatter(
                    "error.accounting.events.AdministrativeOfficeFeeAndInsuranceExemptionJustificationByDispatch.dispatchDate.and.reason.are.required",
                    new LabelFormatter(justificationType.getQualifiedName(), Bundle.ENUMERATION));
        }
    }

    @Override
    public LabelFormatter getDescription() {
        final LabelFormatter labelFormatter = new LabelFormatter();
        labelFormatter.appendLabel(getJustificationType().getQualifiedName(), Bundle.ENUMERATION);
        String dispatchDate = getDispatchDate() != null ? getDispatchDate().toString("dd/MM/yyyy") : "-";
        labelFormatter.appendLabel(" (").appendLabel("label.in", Bundle.APPLICATION).appendLabel(" ").appendLabel(dispatchDate)
                .appendLabel(")");

        return labelFormatter;
    }

}
