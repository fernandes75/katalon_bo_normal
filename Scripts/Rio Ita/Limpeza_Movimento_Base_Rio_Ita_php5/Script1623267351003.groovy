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
selenium.open("http://teste.transoft.com.br:81/sgtweb/index.php")
selenium.click("link=Login Suporte.")
selenium.type("id=edtUsuario", "edson")
selenium.type("id=edtSenha", "ed021061")
selenium.click("id=edtConexao")
selenium.select("id=edtConexao", "label=rioita")
selenium.click("id=edtConexao")
selenium.click("//input[@value='ENTRAR']")
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (selenium.isElementPresent("link=Módulos")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}
selenium.click("link=Módulos")
selenium.click("link=Tráfego / Arrecadação")
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (selenium.isElementPresent("link=Apoio")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}
selenium.click("link=Apoio")
selenium.click("link=Limpeza de Movimento")
selenium.type("id=dtInicial", "26/05/2021")
selenium.type("id=dtFinal", "26/05/2021")
selenium.click("id=empresasBt2")
selenium.click("name=csTipoDocumento")
selenium.select("name=csTipoDocumento", "label=TRANSNET")
selenium.click("name=csTipoDocumento")
selenium.chooseOkOnNextConfirmation()
selenium.click("link=Executar Limpeza de Movimento")
assertTrue(selenium.getConfirmation().matches("^Está operação irá apagar os dados financeiros e operacionais do período\\. Confirma a Operação de limpeza[\\s\\S] "));

// Espera a gravação do documento
Thread.sleep(2000);

//Verifica se a limpeza foi executada com sucesso
def content = selenium.getText('xpath=//*[@id="comunicacao"]/div')
WebUI.verifyMatch(content, '.*Limpeza de movimento executada com sucesso!.*', true)
