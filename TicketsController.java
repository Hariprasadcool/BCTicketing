package com.hp.bc.tickets.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.validation.Valid;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hp.bc.tickets.model.Tickets;
import com.hp.bc.tickets.repo.TicketRepository;

@CrossOrigin
@RestController
public class TicketsController {
	
	@Autowired
	TicketRepository repository;
	
	Map<Long, Tickets> ticketList = new HashMap<Long, Tickets>();
	
	
	//Get All Tickets
		@GetMapping (value="/tickets", produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Tickets> getAllTickets() {
			System.out.println(" Get All Tickets.....");
				List<Tickets> list = new ArrayList<>();
				Iterable<Tickets> tickets = repository.findAll();
				tickets.forEach(list::add);
				return list;
			}
		
		//Get one Ticket details 
		
		@GetMapping (value="/tickets/{defectID}", produces=MediaType.APPLICATION_JSON_VALUE)
			public List<Tickets> getOneTicket(@PathVariable long defectID) {
				System.out.println(" Get One Ticket.....+ defectID ---->"+ defectID);
				return repository.findAllByDefectID(defectID);
			}
		
			
		//add ticket
		
		@PostMapping ("/tickets/create")
		public Tickets createTicket (@Valid @RequestBody Tickets tickets) {
			System.out.println("Create Ticket: " + tickets.getDefectID() + "...");
			return repository.save(tickets);
			}

		// Update updateTickets
		
		
		@PutMapping("/tickets/update/{defectID}")
		public ResponseEntity<Tickets> updateTickets(@PathVariable("defectID") long defectID, @RequestBody Tickets tickets) {
			System.out.println("Update Ticket with defectID = " + defectID + "...");
			Tickets updateTkt = null;
			 List<Tickets> ticketData = repository.findAllByDefectID(defectID);
			
			if (tickets == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			System.out.println("ticketData "+"..."+ticketData.toString());
			
			Iterator<Tickets> updateTicket = ticketData.iterator();
			while (updateTicket.hasNext()) {
				updateTkt = (Tickets) updateTicket.next();
				updateTkt.setIeTickets(tickets.getIeTickets());
				updateTkt.setServiceID(tickets.getServiceID());
				updateTkt.setPmtTime(tickets.getPmtTime());
				updateTkt.setQcID(tickets.getQcID());
				updateTkt.setTdpID(tickets.getTdpID());
				updateTkt.setSummaryID(tickets.getSummaryID());
				updateTkt.setOpenDateID(tickets.getOpenDateID());
				updateTkt.setEstDateID(tickets.getEstDateID());
				updateTkt.setOwnerID(tickets.getOwnerID());
				updateTkt.setPriorityID(tickets.getPriorityID());
				updateTkt.setStatusID(tickets.getStatusID());
				updateTkt.setIssuetypeID(tickets.getIssuetypeID());
				updateTkt.setCategoryID(tickets.getCategoryID());
				updateTkt.setCommentsID(tickets.getCommentsID());
				updateTkt.setWorkstreamID(tickets.getWorkstreamID());
				updateTkt.setMacdID(tickets.getMacdID());
				updateTkt.setPocID(tickets.getPocID());
				updateTkt.setAgeID(tickets.getAgeID());
				updateTkt.setActive(tickets.isActive());
			}
			repository.save(updateTkt);
			System.out.println("Update Ticket with ticketData = " + updateTkt.toString() + "...");
			// Tickets updatedtickets = repository.save();			
			ticketList.put(defectID, updateTkt);
			System.out.println("After updating the Ticket");
	        ticketList.forEach((id, tkt) -> System.out.println(tkt.toString()));
	        
	        return new ResponseEntity<Tickets>((Tickets) updateTkt, HttpStatus.OK);
		}
		
	//update each field
	//PUT /tickets/update/{defectID}
		
	//excel download all data
	//Get /tickets/downloadExcel
		
	@GetMapping("/tickets/downloadCSV")
	public ResponseEntity<InputStreamResource> downloadCSV() throws IOException{
		System.out.println("download excel called");
		FileWriter filewriter =  null;
		try {
		List<Tickets> ticketsList = new ArrayList<Tickets>();
		Iterable<Tickets> tickets = repository.findAll();
		tickets.forEach(ticketsList::add);
		StringBuilder fileContent = new StringBuilder("Defect Number,Internal Engagement Tickets,QC Ticket #,TDP Defect#,Summary,Date Opened,EST Fix Date,Action Item Owner,PMT Out Time( Initial Triage),Services,Priority,Status,Issue Type,Category,Comments,Workstream,MACD/Non-MACD/Gated MACD,POC,Defect Age\n");
		for(Tickets tl:tickets) {
			fileContent.append(tl.getDefectID()).append(",")
			.append(tl.getIeTickets()).append(",")
			.append(tl.getQcID()).append(",")
			.append(tl.getTdpID()).append(",")
			.append(tl.getSummaryID()).append(",")
			.append(tl.getOpenDateID()).append(",")
			.append(tl.getEstDateID()).append(",")
			.append(tl.getOwnerID()).append(",")
			.append(tl.getPmtTime()).append(",")
			.append(tl.getServiceID()).append(",")
			.append(tl.getPriorityID()).append(",")
			.append(tl.getStatusID()).append(",")
			.append(tl.getIssuetypeID()).append(",")
			.append(tl.getCategoryID()).append(",")
			.append(tl.getCommentsID()).append(",")
			.append(tl.getWorkstreamID()).append(",")
			.append(tl.getMacdID()).append(",")
			.append(tl.getPocID()).append(",")
			.append(tl.getAgeID()).append("\n");
		}
		System.out.println(fileContent.toString());
		String filename = "C:\\Users\\hari\\ticketList.csv";
		
		@SuppressWarnings("resource")
		FileWriter fileWriter = new FileWriter(filename);
		fileWriter.write(fileContent.toString());
		fileWriter.flush();
		
		
		File file = new File(filename);
		
		if (!file.exists()) {
			file.createNewFile();
		}
		
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		
		ResponseEntity<InputStreamResource> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);
		return responseEntity;
		} catch (Exception e ) {
			return new ResponseEntity<InputStreamResource>(HttpStatus.INTERNAL_SERVER_ERROR);	
		} finally {
			if(filewriter!=null)
				filewriter.close();
		}
		
	}
	

	@GetMapping("/tickets/downloadexcel")
	public void getDownloadExcel() throws IOException{
		
		String[] COLUMNs = {"Defect Number","Internal Engagement Tickets","QC Ticket #","TDP Defect#","Summary","Date Opened","EST Fix Date","Action Item Owner","PMT Out Time( Initial Triage)","Services","Priority","Status","Issue Type","Category","Comments","Workstream","MACD/Non-MACD/Gated MACD","POC","Defect Age"};
		
		System.out.println("method entered....");
		
		String filename = "C:\\Users\\hari\\Downloads\\ORT_Tickets.xlsx";
		
		List<Tickets> ticketsList = new ArrayList<Tickets>();
		Iterable<Tickets> tickets = repository.findAll();
		tickets.forEach(ticketsList::add);
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		 
		CreationHelper createHelper = workbook.getCreationHelper();
 
		Sheet sheet = workbook.createSheet("All Tickets");
 
		
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setColor(IndexedColors.BLUE.getIndex());
 
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
 
		// Row for Header
		Row headerRow = sheet.createRow(0);
 
		// Header
		for (int col = 0; col < COLUMNs.length; col++) {
			Cell cell = headerRow.createCell(col);
			cell.setCellValue(COLUMNs[col]);
			cell.setCellStyle(headerCellStyle);
		}
 
		// CellStyle for Age
		CellStyle ageCellStyle = workbook.createCellStyle();
		ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
 
		int rowIdx = 1;
		for (Tickets ticket : tickets) {
			Row row = sheet.createRow(rowIdx++);
 
			row.createCell(0).setCellValue(ticket.getDefectID());
			row.createCell(1).setCellValue(ticket.getIeTickets());
			row.createCell(2).setCellValue(ticket.getQcID());
			row.createCell(3).setCellValue(ticket.getTdpID());
			row.createCell(4).setCellValue(ticket.getSummaryID());
			row.createCell(5).setCellValue(ticket.getOpenDateID());
			row.createCell(6).setCellValue(ticket.getEstDateID());
			row.createCell(7).setCellValue(ticket.getOwnerID());
			row.createCell(8).setCellValue(ticket.getPmtTime());
			row.createCell(9).setCellValue(ticket.getServiceID());
			row.createCell(10).setCellValue(ticket.getPriorityID());
			row.createCell(11).setCellValue(ticket.getStatusID());
			row.createCell(12).setCellValue(ticket.getIssuetypeID());
			row.createCell(13).setCellValue(ticket.getCategoryID());
			row.createCell(14).setCellValue(ticket.getCommentsID());
			row.createCell(15).setCellValue(ticket.getWorkstreamID());
			row.createCell(16).setCellValue(ticket.getMacdID());
			row.createCell(17).setCellValue(ticket.getPocID());
 
			Cell ageCell = row.createCell(18);
			ageCell.setCellValue(ticket.getAgeID());
			ageCell.setCellStyle(ageCellStyle);
			System.out.println("method entered...."+ticket.toString());
		}
		try {
		FileOutputStream fileOut = new FileOutputStream(filename);
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();
		sendEmail();
		}catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void sendEmail() throws UnsupportedEncodingException {
		 // Recipient's email ID needs to be mentioned.
	      String to = "testprasad787@gmail.com";

	      // Sender's email ID needs to be mentioned
	      String from = "testprasad787@gmail.com";

	      final String username = "testprasad787@gmail.com";//change accordingly
	      final String password = "Prasad@123";//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.host", host);
			props.put("mail.smtp.socketFactory.port", "587");
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.starttls.enable", true);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
	            }
	         });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject("Testing Subject");

	         // Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Now set the actual message
	         messageBodyPart.setText("This is message body");

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         String filename = "C:\\\\Users\\\\hari\\\\Downloads\\\\ORT_Tickets.xlsx";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent Email with attachment successfully....");
	  
	      } catch (MessagingException e) {
	         throw new RuntimeException(e);
	      }
	   }
}
