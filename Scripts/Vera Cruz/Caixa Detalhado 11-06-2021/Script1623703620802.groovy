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
selenium.open(GlobalVariable.url)
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
selenium.click("link=Tráfego / Arrecadação")
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (selenium.isElementPresent("link=Consultas/Relatorios")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}
selenium.click("link=Consultas/Relatorios")
selenium.click("link=Comparativos Receitas")
selenium.click("link=Caixa Detalhado")
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (selenium.isElementPresent("name=subtiposrelatorios")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

selenium.click("name=subtiposrelatorios")
selenium.select("name=subtiposrelatorios", "label=CX DETALHADO (GERAL)")
selenium.click("name=subtiposrelatorios")

selenium.click("name=csOperacaoArrecadacao")
selenium.select("name=csOperacaoArrecadacao", "label=Data de Arrecadação")
selenium.click("name=csOperacaoArrecadacao")

selenium.click("name=csExibir")
selenium.select("name=csExibir", "label=Data de Arrecadação")
selenium.click("name=csExibir")

selenium.click("name=quebra")
selenium.select("name=quebra", "label=Empresas")
selenium.click("name=quebra")

selenium.click("id=empresasBt2")

selenium.type("id=dtInicio", "11/06/2021")
selenium.type("id=dtFinal", "11/06/2021")

selenium.click("id=idOrdemRelatorioDataDocumento")

selenium.click("id=visualizacao")
selenium.select("id=visualizacao", "label=HTML (Vídeo)")
selenium.click("id=visualizacao")

selenium.click("link=Pesquisar")
Thread.sleep(2000);

selenium.click("//td[@id='conteudoRel']/form/a")

//Verifica se os dados estão coerentes com o(s) documento(s) digitado(s)
def qtPassTot = selenium.getText("//tr[@id='2']/td[20]")
WebUI.verifyMatch(qtPassTot, '.*179.*', true)

def vlRecTot = selenium.getText("//tr[@id='2']/td[28]")
WebUI.verifyMatch(vlRecTot, '.*610,90.*', true)

def qtVtAtual = selenium.getText("//tr[@id='2']/td[19]")
WebUI.verifyMatch(qtVtAtual, '.*95.*', true)

def qtSenior = selenium.getText("//tr[@id='2']/td[8]")
WebUI.verifyMatch(qtSenior, '.*27.*', true)