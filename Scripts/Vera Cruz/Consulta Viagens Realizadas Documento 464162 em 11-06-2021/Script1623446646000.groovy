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
selenium.open("http://teste.transoft.com.br/sgtweb/index.php?c=controleAcesso.CLogin&m=verTelaLogin")
selenium.click("link=Login Suporte.")
selenium.type("id=edtUsuario", "edson")
selenium.type("id=edtSenha", "ed021061")
selenium.click("id=edtConexao")
selenium.select("id=edtConexao", "label=vera")
selenium.click("id=edtConexao")
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
	try { if (selenium.isElementPresent("link=Consultas/Relatorios")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}
selenium.click("link=Consultas/Relatorios")
selenium.click("link=Controle Operacional/Tráfego")
selenium.click("link=Viagens Realizadas por Documento")
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (selenium.isElementPresent("id=idEmpresaBt2")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}
selenium.click("id=idEmpresaBt2")
selenium.type("id=dtViagemRealizadaInicial", "11/06/2021")
selenium.type("id=dtViagemRealizadaFinal", "11/06/2021")
selenium.type("name=nrDocInicial", "464162")
selenium.type("name=nrDocFinal", "464162")
selenium.click("id=visualizacao")
selenium.select("id=visualizacao", "label=HTML (Vídeo)")
selenium.click("id=visualizacao")
selenium.click("link=Pesquisar")

//Verifica se os dados estão coerentes com o documento digitado
def hrSaidaViagem = selenium.getText("//tr[@id='6']/td")
WebUI.verifyMatch(hrSaidaViagem, '.*18:25.*', true)

def qtPassageiros = selenium.getText("//tr[@id='9']/td[8]")
WebUI.verifyMatch(qtPassageiros, '.*7.*', true)

def nrRolChegada = selenium.getText("//tr[@id='3']/td[7]")
WebUI.verifyMatch(nrRolChegada, '.*72886.*', true)

def nrCrachaMot = selenium.getText("//tr[@id='4']/td[13]")
WebUI.verifyMatch(nrCrachaMot, '.*019748.*', true)
