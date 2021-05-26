//package com.template.states;
//import com.template.contracts.DocumentContract;
//import com.template.schema.DocumentSchemav1;
//import com.template.schema.MyIterable;
//import net.corda.core.contracts.BelongsToContract;
//import net.corda.core.contracts.LinearState;
//import net.corda.core.contracts.UniqueIdentifier;
//import net.corda.core.identity.AbstractParty;
//import net.corda.core.schemas.MappedSchema;
//import net.corda.core.schemas.PersistentState;
//import net.corda.core.schemas.QueryableState;
//import net.corda.core.serialization.ConstructorForDeserialization;
//import org.jetbrains.annotations.NotNull;
//
//import java.time.Instant;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author sheenam.garg
// *
// * State object define here.
// *
// *
// */
//@BelongsToContract(DocumentContract.class)
//public class DocumentState implements LinearState {
//
//    private final DocumentMetaData documentMetadata;
//    private final AbstractParty docOwner;
//    private final Instant createdTimeStamp ;
//    private final Instant modifiedTimeStamp ;
//    private final UniqueIdentifier linearId;
//    private final String  entityId ;
//    private final String  entityVersion ;
//
//    public boolean isConfidential() {
//        return confidential;
//    }
//
//    public void setConfidential(boolean confidential) {
//        this.confidential = confidential;
//    }
//
//    private boolean confidential;
//    private String attachmentHash;
//    private String docStatus;
//    private Float docVersion;
//    private  final List<AbstractParty> docReceiversList;
//
//
//    public String getAttachmentHash() {
//        return attachmentHash;
//    }
//
//    public void setAttachmentHash(String attachmentHash) {
//        this.attachmentHash = attachmentHash;
//    }
//
//    public String getDocStatus() {
//        return docStatus;
//    }
//
//    public void setDocStatus(String docStatus) {
//        this.docStatus = docStatus;
//    }
//
//    public Float getDocVersion() {
//        return docVersion;
//    }
//
//    public void setDocVersion(Float docVersion) {
//        this.docVersion = docVersion;
//    }
//
//    public List<AbstractParty> getDocReceiversList() {
//        return docReceiversList;
//    }
//
//    public String getEntityVersion() {
//        return entityVersion;
//    }
//
//    /**
//     * @param
//     * @param
//     * @param createdTimeStamp
//     * @param modifiedTimeStamp
//     * @param docReceiversList
//     */
//
//    @ConstructorForDeserialization
//    public DocumentState(DocumentMetaData documentMetadata,
//                         AbstractParty docOwner,
//                         Instant createdTimeStamp,
//                         Instant modifiedTimeStamp,
//                         UniqueIdentifier linearId, String entityId,
//                         String entityVersion,
//                         boolean confidential,
//                         String attachmentHash,
//                         String docStatus,
//                         Float docVersion,
//                         List<AbstractParty> docReceiversList)
//    {
//        this.documentMetadata = documentMetadata;
//        this.createdTimeStamp = createdTimeStamp;
//        this.modifiedTimeStamp = modifiedTimeStamp;
//        this.linearId = linearId ;
//        this.docOwner = docOwner;
//        this.entityId = entityId ;
//        this.entityVersion = entityVersion ;
//        this.docReceiversList = docReceiversList;
//        this.confidential=confidential;
//        this.attachmentHash=attachmentHash;
//        this.docStatus=docStatus;
//        this.docVersion=docVersion;
//    }
//
//    /**
//     * when you start the DocumentMetaData
//     * @param
//     * @param docReceiversList
//     */
//    public DocumentState(DocumentMetaData documentMetadata,
//                         AbstractParty docOwner,
//                         String entityId,
//                         String entityVersion,
//                         boolean confidential,
//                         String attachmentHash,
//                         List<AbstractParty> docReceiversList)
//    {
//        this.documentMetadata = documentMetadata;
//        this.docReceiversList = docReceiversList;
//        this.createdTimeStamp = Instant.now();
//        this.modifiedTimeStamp = createdTimeStamp;
//        this.attachmentHash=attachmentHash;
//        this.docOwner = docOwner;
//        this.linearId = new UniqueIdentifier();
//        this.entityId = entityId ;
//        this.entityVersion = entityVersion ;
//        this.docStatus="ACTIVE";
//        this.confidential= confidential;
//        this.docVersion=Float.valueOf(1);
//    }
//
//    public DocumentState(DocumentMetaData documentMetadata,
//                         AbstractParty docOwner,
//                         String entityId,
//                         boolean confidential,
//                         String attachmentHash,
//                         List<AbstractParty> docReceiversList)
//    {
//        this.documentMetadata = documentMetadata;
//        this.docReceiversList = docReceiversList;
//        this.createdTimeStamp = Instant.now();
//        this.modifiedTimeStamp = createdTimeStamp;
//        this.attachmentHash=attachmentHash;
//        this.docOwner = docOwner;
//        this.linearId = new UniqueIdentifier();
//        this.entityId = entityId ;
//        this.entityVersion = null ;
//        this.docStatus="ACTIVE";
//        this.confidential= confidential;
//        this.docVersion=Float.valueOf(1);
//    }
//
//
//    /** Copy the docHandling state for editing metadata
//     * @return
//     */
//
//    public DocumentState copy(DocumentMetaData documentMetadata){
//
//        DocumentState docHandlingState = new DocumentState(documentMetadata, this.docOwner,  this.createdTimeStamp,
//                Instant.now(),this.linearId,this.entityId, this.entityVersion, this.confidential,
//                this.attachmentHash, this.docStatus,this.docVersion,this.docReceiversList);
//
//        return docHandlingState ;
//
//    }
//
//    //for sharing document
//    public DocumentState copy(List<AbstractParty> newDocReceiversList){
//
//        DocumentState docHandlingState = new DocumentState(this.documentMetadata, this.docOwner,  this.createdTimeStamp,
//                Instant.now(),this.linearId,this.entityId, this.entityVersion, this.confidential,
//                this.attachmentHash, this.docStatus,this.docVersion,newDocReceiversList);
//
//        return docHandlingState ;
//
//    }
//
//    //for creating new version of a document
//    public DocumentState copy(String attachmentHash){
//
//        DocumentState docHandlingState = new DocumentState(this.documentMetadata, this.docOwner,  this.createdTimeStamp,
//                Instant.now(),this.linearId,this.entityId, this.entityVersion, this.confidential,
//                attachmentHash, this.docStatus,this.docVersion,this.docReceiversList);
//
//        return docHandlingState ;
//
//    }
//
//    @Override
//    public UniqueIdentifier getLinearId() {
//        return linearId;
//    }
//
//    /** The public keys of the involved parties. */
//    @Override
//    public List<AbstractParty> getParticipants() {
//
//        List<AbstractParty> participants = new ArrayList<AbstractParty>();
//
//        participants.add(this.docOwner);
//
//        if(this.docReceiversList != null && !this.docReceiversList.isEmpty()){
//
//            participants.addAll(this.docReceiversList);
//        }
//
//        return participants;
//    }
//
//
//
//    public AbstractParty getDocOwner() {
//        return docOwner;
//    }
//
//    public DocumentMetaData getDocumentMetadata() {
//        return documentMetadata;
//    }
//
//    public Instant getCreatedTimeStamp() {
//        return createdTimeStamp;
//    }
//
//    public Instant getModifiedTimeStamp() {
//        return modifiedTimeStamp;
//    }
//
//    public String getEntityId() {
//        return entityId;
//    }
//
//    @NotNull
//    @Override
//    public Iterable<MappedSchema> supportedSchemas() {
//        return new MyIterable(new DocumentSchemav1());
//    }
//
//    @NotNull
//    @Override
//    public PersistentState generateMappedObject(MappedSchema schema) {
//
//        if (schema instanceof DocumentSchemav1) {
//            return new DocumentSchemav1.PersistentDocumentState(
//                    this.documentMetadata.getDocRef() ,
//                    this.documentMetadata.getDocName(),
//                    this.documentMetadata.getDocType(),
//                    this.documentMetadata.getDocURL() ,
//                    this.documentMetadata.getDocDescription(),
//                    this.entityId, this.entityVersion );
//        } else {
//            throw new IllegalArgumentException("Unrecognised schema $schema");
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "DocumentState{" +
//                "documentMetadata=" + documentMetadata +
//                ", docOwner=" + docOwner +
//                ", createdTimeStamp=" + createdTimeStamp +
//                ", modifiedTimeStamp=" + modifiedTimeStamp +
//                ", linearId=" + linearId +
//                ", entityId='" + entityId + '\'' +
//                ", entityVersion='" + entityVersion + '\'' +
//                ", confidential=" + confidential +
//                ", attachmentHash='" + attachmentHash + '\'' +
//                ", docStatus='" + docStatus + '\'' +
//                ", docVersion=" + docVersion +
//                ", docReceiversList=" + docReceiversList +
//                '}';
//    }
//}
