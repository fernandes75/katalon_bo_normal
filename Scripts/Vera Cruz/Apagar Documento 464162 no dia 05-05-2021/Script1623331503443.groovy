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
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open(GlobalVariable.url)
selenium.click("link=Login Suporte.")
selenium.type("id=edtUsuario", "edson")
selenium.type("id=edtSenha", "ed021061")
selenium.select("id=edtConexao", "label=valorambiental")
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
	try { if (selenium.isElementPresent("link=Movimentação")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

selenium.click("link=Movimentação")
selenium.click("link=Digitacao de Documentos")
selenium.click("link=Digitação Boletim Normal")

for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (selenium.isElementPresent("name=nrDocumento")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

Thread.sleep(5000);

selenium.type("name=idEmpresa", "001")
selenium.typeKeys("name=idEmpresa", Keys.chord(Keys.ENTER))
selenium.type("name=dtOperacao", "05/05/2021")
selenium.typeKeys("name=dtOperacao", Keys.chord(Keys.ENTER))

Thread.sleep(5000);

selenium.type("name=nrDocumento", "464162")
selenium.typeKeys("name=nrDocumento", Keys.chord(Keys.ENTER))
selenium.typeKeys("name=pesquisa", Keys.chord(Keys.ENTER))

Thread.sleep(4000);

selenium.click("link=Exclui")

Thread.sleep(5000);