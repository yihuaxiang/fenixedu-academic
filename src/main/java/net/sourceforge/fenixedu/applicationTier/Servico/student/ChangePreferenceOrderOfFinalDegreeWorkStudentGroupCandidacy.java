/*
 * Created on 2004/04/21
 */
package net.sourceforge.fenixedu.applicationTier.Servico.student;

import net.sourceforge.fenixedu.domain.finalDegreeWork.FinalDegreeWorkGroup;
import net.sourceforge.fenixedu.domain.finalDegreeWork.GroupProposal;
import pt.ist.fenixWebFramework.security.accessControl.Checked;
import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.FenixFramework;

/**
 * @author Luis Cruz
 */
public class ChangePreferenceOrderOfFinalDegreeWorkStudentGroupCandidacy {

    public ChangePreferenceOrderOfFinalDegreeWorkStudentGroupCandidacy() {
        super();
    }

    @Checked("RolePredicates.STUDENT_PREDICATE")
    @Atomic
    public static Boolean run(FinalDegreeWorkGroup group, String groupProposalOID, Integer orderOfPreference) {
        GroupProposal groupProposal = FenixFramework.getDomainObject(groupProposalOID);
        if (group != null && groupProposal != null) {
            for (GroupProposal otherGroupProposal : group.getGroupProposalsSet()) {
                if (otherGroupProposal != null && !groupProposal.getExternalId().equals(otherGroupProposal.getExternalId())) {
                    int otherOrderOfPreference = otherGroupProposal.getOrderOfPreference().intValue();
                    if (orderOfPreference.intValue() <= otherOrderOfPreference
                            && groupProposal.getOrderOfPreference().intValue() > otherOrderOfPreference) {
                        otherGroupProposal.setOrderOfPreference(new Integer(otherOrderOfPreference + 1));
                    } else if (orderOfPreference.intValue() >= otherOrderOfPreference
                            && groupProposal.getOrderOfPreference().intValue() < otherOrderOfPreference) {
                        otherGroupProposal.setOrderOfPreference(new Integer(otherOrderOfPreference - 1));
                    }
                }
            }
            groupProposal.setOrderOfPreference(orderOfPreference);
        }
        return true;
    }

}