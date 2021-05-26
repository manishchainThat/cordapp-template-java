//package com.template.schema;
//
//import net.corda.core.schemas.MappedSchema;
//import net.corda.core.schemas.PersistentState;
//;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//public class DocumentSchemav1 extends MappedSchema {
//    public DocumentSchemav1() {
//        super(DocumentStateSchemaV.class, 1,new MyIterable(PersistentDocumentState.class));
//    }
//
//    @Entity
//    @Table(name = "Document_states")
//    public static class PersistentDocumentState extends PersistentState {
//        //fields to query from Document State ...
//        @Column(name ="docRef")
//        private final String docRef;
//
//        @Column(name ="docName")
//        private final String docName;
//
//        @Column(name ="docType")
//        private final String docType;
//
//        @Column(name ="docURL")
//        private final String docURL;
//
//        @Column(name ="docDescription")
//        private final String docDescription;
//
//        @Column(name ="entityId")
//        private final String entityId ;
//
//        @Column(name ="entityVersion")
//        private final String entityVersion ;
//
//
//
//
//        public String getDocRef() {
//            return docRef;
//        }
//
//        public String getDocName() {
//            return docName;
//        }
//
//        public String getDocType() {
//            return docType;
//        }
//
//        public String getDocURL() {
//            return docURL;
//        }
//
//        public String getDocDescription() {
//            return docDescription;
//        }
//
//        //default constructor for hibernate to use.
//        public PersistentDocumentState(String docRef, String docName, String docType,
//                                       String docURL, String docDescription, String entityId, String entityVersion ) {
//            this.docRef = docRef;
//            this.docName = docName;
//            this.docType = docType;
//            this.docURL = docURL;
//            this.docDescription = docDescription;
//            this.entityId = entityId ;
//            this.entityVersion = entityVersion;
//        }
//
//        public PersistentDocumentState() {
//            this.docRef = null;
//            this.docName = null;
//            this.docType = null;
//            this.docURL = null;
//            this.docDescription = null;
//            this.entityId = null ;
//            this.entityVersion = null;
//        }
//
//    }
//}
