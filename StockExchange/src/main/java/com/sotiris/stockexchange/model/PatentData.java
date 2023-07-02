package com.sotiris.stockexchange.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="patent")
@Getter
public class PatentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "applicationNumber")
    private String applicationNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "filingDate")
    private String filingDate;

    @Column(name = "filingStatus")
    private String filingStatus;

    @Column(name = "patentNumber")
    private String patentNumber;

    @Column(name = "publicationDate")
    private String publicationDate;

    @Column(name = "type")
    private String type;

    @Column(name="url")
    private String url;

    @ManyToOne
    @JoinColumn(name="USPTOCompanyPatents_id")
    private USPTOCompanyPatents usptoCompanyPatents;

    public PatentData( String applicationNumber, String description, String filingDate, String filingStatus, String patentNumber, String publicationDate, String type, String url) {
        this.applicationNumber = applicationNumber;
        this.description = description;
        this.filingDate = filingDate;
        this.filingStatus = filingStatus;
        this.patentNumber = patentNumber;
        this.publicationDate = publicationDate;
        this.type = type;
        this.url = url;
    }
}
