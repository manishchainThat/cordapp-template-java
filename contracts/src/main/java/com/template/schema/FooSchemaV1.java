package com.template.schema;

import net.corda.core.schemas.MappedSchema;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

public class FooSchemaV1 extends MappedSchema {
    public FooSchemaV1() {
        super(FooSchema.class, 1, new MyIterable(PersistentFoo.class));
    }


    @Nullable
    @Override
    public String getMigrationResource() {
        return "foos.changelog-master";
    }

    @Entity
    @Table(name = "foos")
    public static class PersistentFoo implements Serializable {
        @Id
        @Column(name = "foo_id")
        String fooId;

        @Column(name = "foo_data")
        String fooData;

        public PersistentFoo() {
            this.fooId = null;
            this.fooData = null;
        }

        public PersistentFoo(String s, String fooData) {
            this.fooId = s;
            this.fooData = fooData;
        }

        public String getFooId() {
            return fooId;
        }
        public void setFooData(String fooData) {
            this.fooData = fooData;
        }

        public String getFooData() {
            return fooData;
        }

    }
}
