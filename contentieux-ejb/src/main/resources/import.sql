-- You can use this file to load seed data into the database using SQL statements
-- insert into Contrainte (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212') 
--@Id
--	@GeneratedValue
--	private Long id;
--
--	private Integer dossier;
--	private String periode;
--	@Temporal(TemporalType.DATE)
--	private Date dateEmission;
--	@Column(columnDefinition="DECIMAL(9,2)")
--	private BigDecimal montantDu = new BigDecimal(0);
--	
--	@OneToOne(mappedBy="contrainte")
--	private Mandat mandat;


insert into Contrainte(id,dossier,periode,dateemission,montantdu) values(100,101,'1/1/2011','2011-1-1',100);
insert into Contrainte(id,dossier,periode,dateemission,montantdu) values(200,201,'1/2/2011','2011-1-1',200);
insert into Contrainte(id,dossier,periode,dateemission,montantdu) values(300,301,'1/1/2011','2011-1-1',150);
insert into Contrainte(id,dossier,periode,dateemission,montantdu) values(400,401,'1/1/2011','2011-1-1',300);

insert into tgi(id,nom,dept) values(100,'TOULOUSE',33);
insert into tgi(id,nom,dept) values(200,'AUCH',33);
insert into tgi(id,nom,dept) values(300,'PARIS',75);

insert into Huissier(id,nom,tgi_id) values(100,'DUPOND',100);
insert into Huissier(id,nom,tgi_id) values(200,'DURAND',100);
insert into Huissier(id,nom,tgi_id) values(300,'MARTIN',200);
insert into Huissier(id,nom,tgi_id) values(400,'TOURAL',200);
insert into Huissier(id,nom,tgi_id) values(500,'JOUJOU',300);