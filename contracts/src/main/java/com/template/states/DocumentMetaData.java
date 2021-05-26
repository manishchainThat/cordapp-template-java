package com.template.states;

import net.corda.core.serialization.CordaSerializable;

@CordaSerializable
public class DocumentMetaData {
    private String docRef;
    private String docName;
    private String docType;
    private String docURL;
    private String docDescription;

    public DocumentMetaData(String docRef, String docName, String docType, String docDescription,
                            String docURL) {
        this.docRef = docRef;
        this.docName = docName;
        this.docType = docType;
        this.docDescription = docDescription;
        this.docURL= docURL;
    }

    public DocumentMetaData() {
    }

    public String getDocRef() {
        return docRef;
    }

    public void setDocRef(String docRef) {
        this.docRef = docRef;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocURL() {
        return docURL;
    }

    public void setDocURL(String docURL) {
        this.docURL = docURL;
    }

    public String getDocDescription() {
        return docDescription;
    }

    public void setDocDescription(String docDescription) {
        this.docDescription = docDescription;
    }

    @Override
    public String toString() {
        return "DocumentMetaData{" +
                ", docRef='" + docRef + '\'' +
                ", docName='" + docName + '\'' +
                ", docType='" + docType + '\'' +
                ", docURL='" + docURL + '\'' +
                ", docDescription='" + docDescription + '\'' +
                '}';
    }
}
