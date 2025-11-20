package com.qa.makeMyrTrip.util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static com.qa.makeMyrTrip.util.GlobalVariables.driver;

public class ExcelUtilities {

    public static String getLocatorValueFromExcelFile(String element) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook("./src/main/resources/ObjectRepo.xlsx");
        XSSFSheet sheet = workbook.getSheet("PageObjects");

        String locatorVal =null;

        for(int i=1;i<=sheet.getLastRowNum();i++){

           String locatorName =  sheet.getRow(i).getCell(0).getStringCellValue();
           if(locatorName.equals(element)){
               locatorVal = sheet.getRow(i).getCell(1).getStringCellValue();
           }
        }
        workbook.close();
        return locatorVal;
    }

    public static WebElement getElementFromExcel(String locatorType, String pageObject) throws IOException {

        WebElement element=null;
        String obj = ExcelUtilities.getLocatorValueFromExcelFile(pageObject);

        if(locatorType.equals("xpath")){
            element = driver.findElement(By.xpath(obj));
        }
        else if(locatorType.equals("id")){
            element = driver.findElement(By.id(obj));

        }
        else if(locatorType.equals("name")){
            element = driver.findElement(By.name(obj));
        }
        else if(locatorType.equals("class")){
            element = driver.findElement(By.className(obj));
        }
        else if(locatorType.equals("linkText")){
            element = driver.findElement(By.linkText(obj));
        }
        else if(locatorType.equals("tagName")){
            element = driver.findElement(By.tagName(obj));
        }
        return element;
    }

    public static WebElement getElementFromExcel1(String locatorType, String pageObject) throws IOException {

       // WebElement element = null;
        String obj = ExcelUtilities.getLocatorValueFromExcelFile(pageObject);

        WebElement element = switch(locatorType){

            case "xpath" -> driver.findElement(By.xpath(obj));
            case "id" -> driver.findElement(By.id(obj));
            case "name" -> driver.findElement(By.name(obj));
            case "class" -> driver.findElement(By.className(obj));
            case "linkText" -> driver.findElement(By.linkText(obj));
            case "tagName" -> driver.findElement(By.tagName(obj));

            default -> throw new IllegalStateException("Unexpected value: " + locatorType);
        };
        return element;
    }

}
