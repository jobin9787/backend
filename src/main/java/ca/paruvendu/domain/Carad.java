package ca.paruvendu.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

@Entity
//@Table(name = "carad", catalog ="mydatabase")
public class Carad implements Serializable{

	   
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(generator = "uuid")
	    @GenericGenerator(name = "uuid", strategy="uuid")
		private String id;
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;

	    private String firstImageId;
		private String make;
		private String body;
		private String model;
		private String type;
		private int year;
		private int price;
		private int kilometers;
		private String fuel;
		private String iduser;
		private String adtitle;
		private String descr;
		private String adlocation;
		private String address;
		private String phone;
		private String email;
		private String adtype;
		private String soldby;
		private String trans;
		private String color;
		private String Drivetrain;
		private String doorNo;

		

		
		
//		@Column (name="ID")
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		
//		@Column (name="MAKE")
		public String getMake() {
			return make;
		}
		public void setMake(String make) {
			this.make = make;
		}
//		@Column (name="MODEL")
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
			
//		@Column (name="TYPE")
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
//		@Column (name="BODY")
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		
//		@Column (name="YEAR")
			public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		
//		@Column (name="PRICE")
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		
//		@Column (name="KILOMETERS")
		public int getKilometers() {
			return kilometers;
		}
		public void setKilometers(int kilometers) {
			this.kilometers = kilometers;
		}
//		@Column (name="FUEL")
		public String getFuel() {
			return fuel;
		}
		public void setFuel(String fuel) {
			this.fuel = fuel;
		}
		
//		@Column (name="IDUSER")
		public String getIduser() {
			return iduser;
		}
		public void setIduser(String iduser) {
			this.iduser = iduser;
		}
//		@Column (name="ADTITLE")
		public String getAdtitle() {
			return adtitle;
		}
		public void setAdtitle(String adtitle) {
			this.adtitle = adtitle;
		}
//		@Column (name="DESCR")
		public String getDescr() {
			return descr;
		}
		public void setDescr(String descr) {
			this.descr = descr;
		}
//		@Column (name="ADLOCATION")
		public String getAdlocation() {
			return adlocation;
		}
		public void setAdlocation(String adlocation) {
			this.adlocation = adlocation;
		}
		
//		@Column (name="ADDRESS")
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
//		@Column (name="PHONE")
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
//		@Column (name="EMAIL")
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
//		@Column (name="ADTYPE")
		public String getAdtype() {
			return adtype;
		}
		public void setAdtype(String adtype) {
			this.adtype = adtype;
		}
//		@Column (name="SOLDBY")
		public String getSoldby() {
			return soldby;
		}
		public void setSoldby(String soldby) {
			this.soldby = soldby;
		}
		
//		@Column (name="TRANS")
		public String getTrans() {
			return trans;
		}
		public void setTrans(String trans) {
			this.trans = trans;
		}
		
//		@Column (name="COLOR")
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		
//		@Column (name="Drivetrain")
		public String getDrivetrain() {
			return Drivetrain;
		}
		public void setDrivetrain(String drivetrain) {
			Drivetrain = drivetrain;
		}
		
//		@Column (name="firstImageId")
//		@GeneratedValue(generator="system-uuid")
//	    @GenericGenerator(name="system-uuid", strategy = "uuid")
		

//		@Column(name = "firstImageId", unique = true)
		public String getFirstImageId() {
			return firstImageId;
		}
		public void setFirstImageId(String firstImageId) {
			this.firstImageId = firstImageId;
		}

		public String getDoorNo() {
			return doorNo;
		}
		public void setDoorNo(String doorNo) {
			this.doorNo = doorNo;
		}
		
		
		
		

	}


