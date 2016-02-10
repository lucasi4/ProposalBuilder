package proposalBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class ProposalBuilder {
	
	public File file;
	public XWPFDocument doc;
	public XWPFParagraph tempParagraph;
	public XWPFRun tempRun;
	public FileOutputStream fos;
	
	
	public ProposalBuilder(){
	}

	public void createDocFile() {

		try {
			file = new File("TestDoc.docx");
			fos = new FileOutputStream(file.getAbsolutePath());
			

			doc = new XWPFDocument();
			tempParagraph = doc.createParagraph();
			tempRun = tempParagraph.createRun();
			
			String imgFile = "D:\\Users\\Lucas\\workspace\\ProposalBuilder\\Resources\\header.jpg";
			FileInputStream is = new FileInputStream(imgFile);
			
			tempRun.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, imgFile, Units.toEMU(576) , Units.toEMU(126));
			is.close();
			tempRun.addBreak();
			tempRun.addBreak();
			tempRun.addBreak();
			tempRun.addBreak();

			tempRun.setText("Test");
			tempRun.setFontSize(12);
			

		} catch (Exception e) {

		}

	}
	
	public void finish(){
		try{
			createDocFile();
			doc.write(fos);
			fos.close();			
			System.out.println(file.getAbsolutePath()+ " created successfully!");
		} catch(Exception e){
			
		}
	}
}