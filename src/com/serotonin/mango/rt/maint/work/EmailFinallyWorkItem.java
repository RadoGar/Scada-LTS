package com.serotonin.mango.rt.maint.work;

import com.serotonin.mango.util.SendEmailConfig;
import com.serotonin.mango.util.SendEmailData;
import java.util.Map;

public class EmailFinallyWorkItem extends EmailAfterWorkItem {

    private final AfterWork.WorkFinally workFinally;

    protected EmailFinallyWorkItem(SendEmailData sendEmailData,
                                   SendEmailConfig sendEmailConfig,
                                   AfterWork afterWork,
                                   AfterWork.WorkFinally workFinally,
                                   WorkItemDetails workItemDetails) {
        super(sendEmailData, sendEmailConfig, afterWork, workItemDetails);
        this.workFinally = workFinally;
    }

    public static WorkItem newInstance(SendEmailData sendEmailData, SendEmailConfig sendEmailConfig,
                                       AfterWork afterWork, AfterWork.WorkFinally workFinally, WorkItemDetails workItemDetails) {
        return new EmailFinallyWorkItem(sendEmailData, sendEmailConfig, afterWork, workFinally, workItemDetails);
    }

    @Override
    public void workFinally(Map<String, Exception> exceptions) {
        this.workFinally.workFinally(exceptions);
    }

    @Override
    public void workFinallyFail(Exception finallyException, Map<String, Exception> exceptions) {
        this.workFinally.workFinallyFail(finallyException, exceptions);
    }

    @Override
    public String toString() {
        return "EmailFinallyWorkItem{" + super.toString() + '}';
    }

    @Override
    public String getDetails() {
        return this.toString();
    }
}
