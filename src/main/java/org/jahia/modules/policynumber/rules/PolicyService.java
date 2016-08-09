package org.jahia.modules.policynumber.rules;
/**
 * Created by fabriceaissah on 8/9/16.
 */

import org.jahia.services.content.JCRNodeWrapper;
import org.jahia.services.content.rules.AddedNodeFact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;

public class PolicyService {

    private static final Logger logger = LoggerFactory.getLogger(PolicyService.class);

    public void setPolicyNumber(AddedNodeFact node) {
        try {
            final JCRNodeWrapper insuranceContract = node.getNode();
            if (insuranceContract.isNodeType("jpnt:insuranceContract")){
                String uuid = insuranceContract.getIdentifier();
                String policyNumber = uuid.replaceAll("-","");
                insuranceContract.setProperty("policyNumber",policyNumber);
                insuranceContract.saveSession();
            }
        } catch (RepositoryException e1) {
            logger.error("Coudn't set the policy number on the contract", e1);
        }
        }
    }
