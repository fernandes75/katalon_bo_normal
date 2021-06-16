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
selenium.select("id=edtConexao", "label=vera")
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
selenium.click("link=Controle Operacional/Tráfego")
selenium.click("link=Desempenho Diário das Linhas")
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (selenium.isElementPresent("id=quebra")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}
selenium.click("id=quebra")
selenium.select("id=quebra", "label=Empresas")
selenium.click("id=quebra")
selenium.type("name=dtInicio", "11/06/2021")
selenium.type("name=dtFim", "11/06/2021")
Thread.sleep(1000);
//selenium.click("//div[@id='tabRelatorio']/form/table/tbody/tr[2]/td/table/tbody/tr[2]")
selenium.click("id=empresasBt2")
selenium.click("id=linhasBt2")
selenium.click("id=setoresOperacionaisAjaxBt2")
selenium.click("id=tipoRelatorio")
selenium.click("id=tipoRelatorio")
selenium.click("id=diaSemanaIncluirDiasUteis")
selenium.click("id=diaSemanaIncluirDiasNaoUteis")
selenium.click("name=tipoRelatorio")
selenium.select("name=tipoRelatorio", "label=Relatório Acumulado")
selenium.click("name=tipoRelatorio")
selenium.click("name=configRelatorio")
selenium.select("name=configRelatorio", "label=Deslin Vera Cruz")
selenium.click("name=configRelatorio")
selenium.click("id=quebraTurno")
selenium.click("id=quebraTurno")
selenium.click("id=quebraTurno")
selenium.select("id=quebraTurno", "label=Linha/Turno")
selenium.click("id=quebraTurno")
selenium.click("id=visualizacao")
selenium.select("id=visualizacao", "label=HTML (Vídeo)")
selenium.click("id=visualizacao")
selenium.click("xpath=(//a[@id=''])[2]")

// Verifica se a pesquisa foi concluída
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (selenium.isElementPresent("//div[@id='comunicacao']/div")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

//Verifica se a pesquisa foi executada com sucesso
def mensagem = selenium.getText("//div[@id='comunicacao']/div")
WebUI.verifyMatch(mensagem, '.*Pesquisa realizada com sucesso!.*', true)

//Verifica se os dados estão coerentes com o(s) documento(s) digitado(s)
def turno = selenium.getText("xpath=//tr[@id='3']/td")
WebUI.verifyMatch(turno, '.*2.*', true)

def qtVtBu = selenium.getText("xpath=//tr[@id='3']/td[5]")
WebUI.verifyMatch(qtVtBu, '.*109.*', true)

def qtTotModal = selenium.getText("xpath=//tr[@id='3']/td[7]")
WebUI.verifyMatch(qtTotModal, '.*149.*', true)

def vlVtBu = selenium.getText("xpath=//tr[@id='3']/td[11]")
WebUI.verifyMatch(vlVtBu, '.*446,90.*', true)

def vlTotal = selenium.getText("xpath=//tr[@id='3']/td[15]")
WebUI.verifyMatch(vlTotal, '.*610,90.*', true)

def vlTotalDeslin = selenium.getText("xpath=//tr[@id='8']/td[15]")
WebUI.verifyMatch(vlTotalDeslin, '.*610,90.*', true)
