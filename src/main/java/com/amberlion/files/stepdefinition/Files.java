package com.amberlion.files.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;

public class Files {

    public static final String ROOT_PUBLIC_DIRECTORY = "C:\\Users\\Public\\Workspace";
    public static File directory;
    public static File file;


    @Given("A new directory is created")
    public void a_new_directory_is_created() {
        directory = new File(ROOT_PUBLIC_DIRECTORY);
        directory.mkdir();
    }

    @When("A file is created")
    public void a_file_is_created() throws IOException {
        file = new File(ROOT_PUBLIC_DIRECTORY + "\\file.txt");
        if(file.createNewFile()) {
            System.out.println("A new file is created");
        } else {
            System.out.println("The file already exists");
        }
        file.deleteOnExit();
    }
    @Then("The file should exist")
    public void the_file_should_exist() {
        Assert.assertTrue("Directory is not present", file.exists());
    }
}
