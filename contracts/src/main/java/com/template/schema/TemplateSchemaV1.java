package com.template.schema;

import net.corda.core.identity.Party;
import net.corda.core.schemas.MappedSchema;
import net.corda.core.schemas.PersistentState;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

public class TemplateSchemaV1 extends MappedSchema {
    public TemplateSchemaV1() {
        super(TemplateSchemaV.class, 1, new MyIterable(TemplateSchemaV1.PersistentTemplateState.class));
    }
    @Nullable
    @Override
    public String getMigrationResource() {
        return "template.changelog-master";
    }

    @Entity
    @Table(name = "template_states")
    public static class PersistentTemplateState extends PersistentState {
        //fields to query from Document State ...
        //private variables
        @Column(name = "msg")
        private final String msg;

        @Column(name = "sender")
        private final Party sender;
        @Column(name = "receiver")
        private final Party receiver;
        @Column(name = "constraint_type")
        private final Integer constraint_type;



        public PersistentTemplateState(String msg, Party sender, Party receiver,Integer constraint_type) {
            this.msg = msg;
            this.sender = sender;
            this.receiver = receiver;
            this.constraint_type = constraint_type;
        }

        public PersistentTemplateState() {
            this.msg = "";
            this.sender = null;
            this.receiver = null;
            this.constraint_type= 0 ;
        }

        public String getMsg() {
            return msg;
        }

        public Party getSender() {
            return sender;
        }

        public Party getReceiver() {
            return receiver;
        }
    }
}
