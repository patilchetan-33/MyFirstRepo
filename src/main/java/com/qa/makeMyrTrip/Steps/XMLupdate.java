package com.qa.makeMyrTrip.Steps;

import com.qa.makeMyrTrip.util.XMLUtils;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class XMLupdate {

    String xmlPath = System.getProperty("user.dir") + "/src/test/resources/student.xml";
    String readValue;

//    @Given("the XML user attribute {string} is updated to {string}")
//    public void update_user_attribute(String attribute, String value) throws Exception {
//        XMLUtils.updateAttributes(xmlPath, "User", new String[][]{
//                {attribute, value}
//        });
//    }

    @Given("the XML user attribute {string} is updated to {string}")
    public void the_xml_user_attribute_is_updated_to(String attribute, String value) throws Exception {
        XMLUtils.updateAttributes(xmlPath, "User", new String[][]{
                {attribute, value}
        });
    }



    @And("I update nested node {string} attribute {string} to {string}")
    public void update_nested_node(String path, String attr, String newValue) throws Exception {
        String[] tagPath = path.split(">");
        XMLUtils.updateNestedNode(xmlPath, tagPath, attr, newValue);
    }

    @And("I update user with id {string} to have role {string}")
    public void update_user_by_id(String userId, String newRole) throws Exception {
        XMLUtils.updateNodeByValue(
                xmlPath,
                "User",
                "id",
                userId,
                "role",
                newRole
        );
    }


    @And("I use {string} to update {string}  {string} {string} {string}")
    public void iUseToUpdate(String tagName,
                             String attrNameToMatch, String valueToMatch,
                             String attrToUpdate, String newValue) throws Exception {
        XMLUtils.updateNodeByValue(xmlPath,"User","id","303","status","active");
    }
}
