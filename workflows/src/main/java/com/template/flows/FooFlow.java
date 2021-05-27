package com.template.flows;

import co.paralleluniverse.fibers.Suspendable;
import com.template.contracts.TemplateContract;
import com.template.schema.FooSchemaV1;
import com.template.states.TemplateState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.*;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;
import net.corda.core.utilities.ProgressTracker;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

// ******************
// * Initiator flow *
// ******************
@InitiatingFlow
@StartableByRPC
public class FooFlow extends FlowLogic<String> {

    //private variables
    private String fooData ;

    //public constructor
    public FooFlow(String fooData){
        this.fooData = fooData;
    }

    @Suspendable
    @Override
    public String call() throws FlowException {
        //Hello World message
        String msg = "Hello-World";
        FooSchemaV1.PersistentFoo foo = new FooSchemaV1.PersistentFoo(new UniqueIdentifier().toString(),fooData);
        try {
            System.out.println("start adddinng the data to foo");
            getServiceHub().withEntityManager((Consumer<EntityManager>) entityManager -> {
                entityManager.persist(foo);
                // Manually trigger a flush on the intermediate session
                entityManager.flush();
                throw new RuntimeException("Non-database error");
            });
        } catch (Exception e) {
            getLogger().info("I still want to save that entity");
        }
       return "manish done";
    }
}
