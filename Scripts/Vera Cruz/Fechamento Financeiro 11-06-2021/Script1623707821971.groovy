import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import com.thoughtworks.selenium.Selenium
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join

WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open("http://teste.transoft.com.br/sgtweb/index.php")
selenium.click("link=Login Suporte.")
selenium.type("id=edtUsuario", "edson")
selenium.type("id=edtSenha", "ed021061")
selenium.select("id=edtConexao", "label=vera")
selenium.click("//input[@value='ENTRAR']")
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (selenium.isElementPresent("link=Módulos")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}
selenium.click("link=Módulos")
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (selenium.isElementPresent("link=Tráfego / Arrecadação")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}
selenium.click("link=Tráfego / Arrecadação")
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (selenium.isElementPresent("link=Apoio")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}
selenium.click("link=Apoio")
selenium.click("link=Fechamentos")
selenium.click("link=Fechamento Financeiro")
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (selenium.isElementPresent("name=Input_idEmpresa")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}
selenium.type("name=Input_idEmpresa", "001")
selenium.type("id=dtInicial", "11/06/2021")
selenium.type("id=dtFinal", "11/06/2021")
selenium.click("name=csOpcaoFechamento")
selenium.select("name=csOpcaoFechamento", "label=Empresa")
selenium.click("name=csOpcaoFechamento")
selenium.click("link=Executar Fechamento")

// Verifica se o fechamento foi concluído
for (int second = 0;; second++) {
	if (second >= 180) fail("timeout");
	try { if (selenium.isElementPresent("//div[@id='comunicacao']/div")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

//Verifica se o fechamento foi executado com sucesso
def mensagem = selenium.getText("//div[@id='comunicacao']/div")
WebUI.verifyMatch(mensagem, '.*Fechamento executado com sucesso!.*', true)
