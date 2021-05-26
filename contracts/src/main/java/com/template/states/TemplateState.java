package com.template.states;

import com.template.contracts.TemplateContract;
import com.template.schema.MyIterable;
import com.template.schema.TemplateSchemaV1;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.schemas.MappedSchema;
import net.corda.core.schemas.PersistentState;
import net.corda.core.schemas.QueryableState;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

// *********
// * State *
// *********
@BelongsToContract(TemplateContract.class)
public class TemplateState implements  QueryableState {

    //private variables
    private String msg;
    private Party sender;
    private Party receiver;
    private final Integer constraint_type;

    /* Constructor of your Corda state */
    public TemplateState(String msg, Party sender, Party receiver, Integer constraint_type) {
        this.msg = msg;
        this.sender = sender;
        this.receiver = receiver;
        this.constraint_type = constraint_type;
    }
    public TemplateState(String msg, Party sender, Party receiver) {
        this.msg = msg;
        this.sender = sender;
        this.receiver = receiver;
        this.constraint_type = 0;
    }
    //getters
    public String getMsg() { return msg; }
    public Party getSender() { return sender; }
    public Party getReceiver() { return receiver; }

    /* This method will indicate who are the participants and required signers when
     * this state is used in a transaction. */
    @Override
    public List<AbstractParty> getParticipants() {
        return Arrays.asList(sender,receiver);
    }



    @NotNull
    @Override
    public PersistentState generateMappedObject(@NotNull MappedSchema schema) {
        if (schema instanceof TemplateSchemaV1) {
            return new TemplateSchemaV1.PersistentTemplateState(
                    this.msg ,
                    this.sender,
                    this.receiver,
                    this.constraint_type);
        } else {
            throw new IllegalArgumentException("Unrecognised schema $schema");
        }
    }

    @NotNull
    @Override
    public Iterable<MappedSchema> supportedSchemas() {
        return new MyIterable(new TemplateSchemaV1());
    }
}