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
selenium.open("http://teste.transoft.com.br/sgtweb/index.php?c=controleAcesso.CLogin&m=verTelaLogin")
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

Thread.sleep(2000);

selenium.type("name=nrDocumento", "019748")
selenium.typeKeys("name=nrDocumento", Keys.chord(Keys.ENTER))

selenium.typeKeys("name=pesquisa", Keys.chord(Keys.ENTER))

Thread.sleep(3000);

//Verifica se a filipeta foi localizada
def nrOrdemEquipamento = selenium.getValue('name=arRolHod6[]')
WebUI.verifyMatch(nrOrdemEquipamento, '.*04045.*', true)

def nrCrahaMotorista = selenium.getValue('name=arRolHod8[]')
WebUI.verifyMatch(nrCrahaMotorista, '.*019748.*', true)

def hrSaidaViagem = selenium.getValue('xpath=(//input[@name="arViagens1[]"])[3]')
WebUI.verifyMatch(hrSaidaViagem, '.*09:49.*', true)

def qtPassSenior = selenium.getValue('xpath=(//input[@name="arQtdCategoria[]"])[11]')
WebUI.verifyMatch(qtPassSenior, '.*27.*', true)

selenium.type("name=arRolHod3[]", "464162")
selenium.typeKeys("name=arRolHod3[]", Keys.chord(Keys.ENTER))

selenium.typeKeys("name=arRolHod4[]", Keys.chord(Keys.ENTER))
selenium.typeKeys("name=arRolHod6[]", Keys.chord(Keys.ENTER))
selenium.typeKeys("name=arRolHod7[]", Keys.chord(Keys.ENTER))
selenium.typeKeys("name=arRolHod8[]", Keys.chord(Keys.ENTER))
selenium.typeKeys("name=arRolHod9[]", Keys.chord(Keys.ENTER))
selenium.typeKeys("name=arRolHod10[]", Keys.chord(Keys.ENTER))
selenium.typeKeys("name=arRolHod11[]", Keys.chord(Keys.ENTER))
selenium.type("name=arRolHod15[]", "73049")
selenium.typeKeys("name=arRolHod15[]", Keys.chord(Keys.ENTER))
Thread.sleep(3000);
selenium.type("name=arRolHod14[]", "72870")
selenium.typeKeys("name=arRolHod14[]", Keys.chord(Keys.ENTER))
selenium.typeKeys("name=arRolHod16[]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arRolHod1[]'])[2]", Keys.chord(Keys.DOWN))
Thread.sleep(1000);
selenium.typeKeys("id=cdLinha", Keys.chord(Keys.ENTER))
selenium.typeKeys("name=nTotPasVei", Keys.chord(Keys.ENTER))
selenium.type("id=cdSaidaGaragem", "22")
selenium.typeKeys("id=cdSaidaGaragem", Keys.chord(Keys.ENTER))
Thread.sleep(1000);
selenium.type("name=hrSaidaGaragem", "1540")
selenium.typeKeys("name=hrSaidaGaragem", Keys.chord(Keys.ENTER))

//Digitação das Viagens do Documento
selenium.type("name=arViagens1[]", "1540")
selenium.typeKeys("name=arViagens1[]", Keys.chord(Keys.ENTER))
selenium.type("name=arViagens2[]", "626")
selenium.typeKeys("name=arViagens2[]", Keys.chord(Keys.ENTER))
selenium.type("name=arViagens3[]", "22")
selenium.typeKeys("name=arViagens3[]", Keys.chord(Keys.ENTER))
selenium.type("name=arViagens5[]", "1625")
selenium.typeKeys("name=arViagens5[]", Keys.chord(Keys.ENTER))
selenium.type("name=arViagens6[]", "27")
selenium.typeKeys("name=arViagens6[]", Keys.chord(Keys.ENTER))
selenium.type("name=arViagens8[]", "72886")
selenium.typeKeys("name=arViagens8[]", Keys.chord(Keys.ENTER))
selenium.typeKeys("name=arViagens9[]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arViagens1[]'])[2]", "1630")
selenium.typeKeys("xpath=(//input[@name='arViagens1[]'])[2]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens2[]'])[2]", "626")
selenium.typeKeys("xpath=(//input[@name='arViagens2[]'])[2]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens3[]'])[2]", "27")
selenium.typeKeys("xpath=(//input[@name='arViagens3[]'])[2]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens5[]'])[2]", "1725")
selenium.typeKeys("xpath=(//input[@name='arViagens5[]'])[2]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens6[]'])[2]", "22")
selenium.typeKeys("xpath=(//input[@name='arViagens6[]'])[2]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens8[]'])[2]", "72932")
selenium.typeKeys("xpath=(//input[@name='arViagens8[]'])[2]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens9[]'])[2]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arViagens1[]'])[3]", "1730")
selenium.typeKeys("xpath=(//input[@name='arViagens1[]'])[3]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens2[]'])[3]", "626")
selenium.typeKeys("xpath=(//input[@name='arViagens2[]'])[3]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens3[]'])[3]", "22")
selenium.typeKeys("xpath=(//input[@name='arViagens3[]'])[3]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens5[]'])[3]", "1820")
selenium.typeKeys("xpath=(//input[@name='arViagens5[]'])[3]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens6[]'])[3]", "27")
selenium.typeKeys("xpath=(//input[@name='arViagens6[]'])[3]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens8[]'])[3]", "72945")
selenium.typeKeys("xpath=(//input[@name='arViagens8[]'])[3]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens9[]'])[3]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arViagens1[]'])[4]", "1825")
selenium.typeKeys("xpath=(//input[@name='arViagens1[]'])[4]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens2[]'])[4]", "626")
selenium.typeKeys("xpath=(//input[@name='arViagens2[]'])[4]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens3[]'])[4]", "27")
selenium.typeKeys("xpath=(//input[@name='arViagens3[]'])[4]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens5[]'])[4]", "1920")
selenium.typeKeys("xpath=(//input[@name='arViagens5[]'])[4]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens6[]'])[4]", "22")
selenium.typeKeys("xpath=(//input[@name='arViagens6[]'])[4]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens8[]'])[4]", "72997")
selenium.typeKeys("xpath=(//input[@name='arViagens8[]'])[4]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens9[]'])[4]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arViagens1[]'])[5]", "1925")
selenium.typeKeys("xpath=(//input[@name='arViagens1[]'])[5]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens2[]'])[5]", "626")
selenium.typeKeys("xpath=(//input[@name='arViagens2[]'])[5]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens3[]'])[5]", "22")
selenium.typeKeys("xpath=(//input[@name='arViagens3[]'])[5]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens5[]'])[5]", "2010")
selenium.typeKeys("xpath=(//input[@name='arViagens5[]'])[5]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens6[]'])[5]", "27")
selenium.typeKeys("xpath=(//input[@name='arViagens6[]'])[5]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens8[]'])[5]", "73008")
selenium.typeKeys("xpath=(//input[@name='arViagens8[]'])[5]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens9[]'])[5]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arViagens1[]'])[6]", "2015")
selenium.typeKeys("xpath=(//input[@name='arViagens1[]'])[6]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens2[]'])[6]", "626")
selenium.typeKeys("xpath=(//input[@name='arViagens2[]'])[6]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens3[]'])[6]", "27")
selenium.typeKeys("xpath=(//input[@name='arViagens3[]'])[6]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens5[]'])[6]", "2100")
selenium.typeKeys("xpath=(//input[@name='arViagens5[]'])[6]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens6[]'])[6]", "22")
selenium.typeKeys("xpath=(//input[@name='arViagens6[]'])[6]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens8[]'])[6]", "73031")
selenium.typeKeys("xpath=(//input[@name='arViagens8[]'])[6]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens9[]'])[6]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arViagens1[]'])[7]", "2110")
selenium.typeKeys("xpath=(//input[@name='arViagens1[]'])[7]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens2[]'])[7]", "626")
selenium.typeKeys("xpath=(//input[@name='arViagens2[]'])[7]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens3[]'])[7]", "22")
selenium.typeKeys("xpath=(//input[@name='arViagens3[]'])[7]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens5[]'])[7]", "2145")
selenium.typeKeys("xpath=(//input[@name='arViagens5[]'])[7]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens6[]'])[7]", "27")
selenium.typeKeys("xpath=(//input[@name='arViagens6[]'])[7]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens8[]'])[7]", "73038")
selenium.typeKeys("xpath=(//input[@name='arViagens8[]'])[7]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens9[]'])[7]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arViagens1[]'])[8]", "2150")
selenium.typeKeys("xpath=(//input[@name='arViagens1[]'])[8]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens2[]'])[8]", "626")
selenium.typeKeys("xpath=(//input[@name='arViagens2[]'])[8]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens3[]'])[8]", "27")
selenium.typeKeys("xpath=(//input[@name='arViagens3[]'])[8]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens5[]'])[8]", "2230")
selenium.typeKeys("xpath=(//input[@name='arViagens5[]'])[8]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens6[]'])[8]", "22")
selenium.typeKeys("xpath=(//input[@name='arViagens6[]'])[8]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens8[]'])[8]", "73049")
selenium.typeKeys("xpath=(//input[@name='arViagens8[]'])[8]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens9[]'])[8]", Keys.chord(Keys.ENTER))

selenium.typeKeys("xpath=(//input[@name='arViagens1[]'])[9]", Keys.chord(Keys.DOWN))

selenium.type("id=cdChegaGaragem", "02")
selenium.typeKeys("id=cdChegaGaragem", Keys.chord(Keys.ENTER))

selenium.type("name=hrChegaGaragem", "2245")
selenium.typeKeys("name=hrChegaGaragem", Keys.chord(Keys.ENTER))

//Digitacao do Bloco de Receitas
selenium.typeKeys("name=arQtdCategoria[]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[2]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[3]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[4]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[5]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[6]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[7]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[8]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[9]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[10]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[11]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[12]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[13]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[14]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[15]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[16]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arRecCategoria[]'])[17]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arRecCategoria[]'])[18]", Keys.chord(Keys.ENTER))

//Digitação Bloco Identificação de Arrecadação
selenium.typeKeys("id=dtArrec", Keys.chord(Keys.ENTER))
selenium.type("name=cdCaixa", "11258")
selenium.typeKeys("name=cdCaixa", Keys.chord(Keys.ENTER))
selenium.type("name=cdSeqCai", "04")
selenium.typeKeys("name=cdSeqCai", Keys.chord(Keys.ENTER))
selenium.type("name=cdSetor", "001")
selenium.typeKeys("name=cdSetor", Keys.chord(Keys.ENTER))

//Dispara rotina de gravação do documento
selenium.typeKeys("name=gravar", Keys.chord(Keys.ENTER))
Thread.sleep(5000);

//Verifica se o documento foi gravado com sucesso
def content = selenium.getText('//*[@id="Mensagens"]/center/font')
WebUI.verifyMatch(content, '.*Acerto atualizado com sucesso!.*', true)