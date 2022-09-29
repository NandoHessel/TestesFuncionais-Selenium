package br.sp.fernandohessel.funcionaltesting;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class FuncionalTest {

    WebDriver driver = new ChromeDriver();

    private By addTodo = By.id("addTodo");
    private By inputTask = By.id("task");
    private By inputDate = By.id("dueDate");
    private By save = By.cssSelector("#saveButton");
    private By valid = By.id("message");


    @Test
    public void DeveSalvarTarefaComSucesso() {
        //Acessar o endereço
        driver.navigate().to("http://localhost:8001/tasks/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Clicar em todo
        driver.findElement(addTodo).click();

        //Escrever desrição
        driver.findElement(inputTask).sendKeys("Descrição");

        //Informar data
        driver.findElement(inputDate).sendKeys("2022-10-12");

        //Salvar
        driver.findElement(save).click();

        //Validar mensagem de sucesso
        /*String text = driver.findElement(valid).getText();
        Assert.assertEquals("A very simple task management tool", text);*/

    }

    @Test
    public  void NaoDeveCadastrarComDataPassad() {
        //Acessar o endereço
        driver.navigate().to("http://localhost:8001/tasks/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Clicar em todo
        driver.findElement(addTodo).click();

        //Escrever desrição
        driver.findElement(inputTask).sendKeys("Descrição");

        //Informar data
        driver.findElement(inputDate).sendKeys("2020-10-12");

        //Salvar
        driver.findElement(save).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Validar mensagem de sucesso
        /*String text = driver.findElement(valid).getText();
        Assert.assertEquals("Due date must not be in past", text);*/
    }
}
