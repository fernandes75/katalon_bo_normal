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
selenium.open("http://teste.transoft.com.br:81/sgtweb/index.php")
selenium.click("link=Login Suporte.")
selenium.click("id=edtUsuario")
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
	try { if (selenium.isElementPresent("name=arRolHod1[]")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

//Digitação de Identificação do Documento
selenium.type("name=arRolHod1[]", "001")
selenium.typeKeys("name=arRolHod1[]", Keys.chord(Keys.ENTER))
selenium.type("id=arRolHod2[]", "26/05/2021")
selenium.typeKeys("id=arRolHod2[]", Keys.chord(Keys.ENTER))
selenium.type("name=arRolHod3[]", "802920")
selenium.typeKeys("name=arRolHod3[]", Keys.chord(Keys.ENTER))
selenium.type("name=arRolHod4[]", "2")
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (selenium.isEditable("name=arRolHod100[]")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}

selenium.type("name=arRolHod100[]", "001")
selenium.typeKeys("name=arRolHod100[]", Keys.chord(Keys.ENTER))
selenium.type("name=arRolHod6[]", "RJ152004")
selenium.typeKeys("name=arRolHod6[]", Keys.chord(Keys.ENTER))
for (int second = 0;; second++) {
	if (second >= 60) fail("timeout");
	try { if (selenium.isEditable("name=arRolHod8[]")) break; } catch (Exception e) {}
	Thread.sleep(1000);
}
selenium.type("name=arRolHod7[]", "001")
selenium.typeKeys("name=arRolHod7[]", Keys.chord(Keys.ENTER))
Thread.sleep(2000);
selenium.type("name=arRolHod8[]", "25964")
selenium.typeKeys("name=arRolHod8[]", Keys.chord(Keys.ENTER))
selenium.type("name=arRolHod9[]", "001")
selenium.typeKeys("name=arRolHod9[]", Keys.chord(Keys.ENTER))
selenium.type("name=arRolHod10[]", "25964")
selenium.typeKeys("name=arRolHod10[]", Keys.chord(Keys.ENTER))
selenium.type("name=arRolHod13[]", "2")
selenium.typeKeys("name=arRolHod13[]", Keys.chord(Keys.ENTER))
selenium.type("name=arRolHod12[]", "999999")
selenium.typeKeys("name=arRolHod12[]", Keys.chord(Keys.ENTER))
selenium.type("name=arRolHod15[]", "18300")
Thread.sleep(7000);
selenium.typeKeys("name=arRolHod15[]", Keys.chord(Keys.ENTER))
selenium.type("name=arRolHod14[]", "18110")
selenium.typeKeys("name=arRolHod14[]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arRolHod1[]'])[2]", Keys.chord(Keys.DOWN))
selenium.type("id=cdLinha", "516M")
selenium.typeKeys("id=cdLinha", Keys.chord(Keys.ENTER))
Thread.sleep(2000);
selenium.typeKeys("name=nTotPasVei", Keys.chord(Keys.ENTER))
selenium.type("id=cdSaidaGaragem", "025")

//Digitação das Viagens do Documento
selenium.typeKeys("id=cdSaidaGaragem", Keys.chord(Keys.ENTER))
selenium.type("name=arViagens1[]", "1338")
selenium.typeKeys("name=arViagens1[]", Keys.chord(Keys.ENTER))
selenium.type("name=arViagens2[]", "516M")
selenium.typeKeys("name=arViagens2[]", Keys.chord(Keys.ENTER))
selenium.type("name=arViagens3[]", "025")
selenium.typeKeys("name=arViagens3[]", Keys.chord(Keys.ENTER))
selenium.type("name=arViagens5[]", "1446")
selenium.typeKeys("name=arViagens5[]", Keys.chord(Keys.ENTER))
selenium.type("name=arViagens6[]", "032")
selenium.typeKeys("name=arViagens6[]", Keys.chord(Keys.ENTER))
selenium.type("name=arViagens8[]", "18177")
selenium.typeKeys("name=arViagens8[]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arViagens1[]'])[2]", "1448")
selenium.typeKeys("xpath=(//input[@name='arViagens1[]'])[2]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens2[]'])[2]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens3[]'])[2]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens5[]'])[2]", "1545")
selenium.typeKeys("xpath=(//input[@name='arViagens5[]'])[2]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens6[]'])[2]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens8[]'])[2]", "18200")
selenium.typeKeys("xpath=(//input[@name='arViagens8[]'])[2]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arViagens1[]'])[3]", "1547")
selenium.typeKeys("xpath=(//input[@name='arViagens1[]'])[3]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens2[]'])[3]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens3[]'])[3]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens5[]'])[3]", "1650")
selenium.typeKeys("xpath=(//input[@name='arViagens5[]'])[3]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens6[]'])[3]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens8[]'])[3]", "18235")
selenium.typeKeys("xpath=(//input[@name='arViagens8[]'])[3]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arViagens1[]'])[4]", "1656")
selenium.typeKeys("xpath=(//input[@name='arViagens1[]'])[4]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens2[]'])[4]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens3[]'])[4]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens5[]'])[4]", "1805")
selenium.typeKeys("xpath=(//input[@name='arViagens5[]'])[4]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens6[]'])[4]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens8[]'])[4]", "18260")
selenium.typeKeys("xpath=(//input[@name='arViagens8[]'])[4]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arViagens1[]'])[5]", "1807")
selenium.typeKeys("xpath=(//input[@name='arViagens1[]'])[5]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens2[]'])[5]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens3[]'])[5]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens5[]'])[5]", "1920")
selenium.typeKeys("xpath=(//input[@name='arViagens5[]'])[5]", Keys.chord(Keys.ENTER))
selenium.typeKeys("xpath=(//input[@name='arViagens6[]'])[5]", Keys.chord(Keys.ENTER))
selenium.type("xpath=(//input[@name='arViagens8[]'])[5]", "18300")
selenium.typeKeys("xpath=(//input[@name='arViagens8[]'])[5]", Keys.chord(Keys.ENTER))

selenium.typeKeys("xpath=(//input[@name='arViagens1[]'])[6]", Keys.chord(Keys.DOWN))

selenium.type("name=cdChegaGaragem", "025")
selenium.typeKeys("name=cdChegaGaragem", Keys.chord(Keys.ENTER))

//Digitação das informações de categorias de passageiros
selenium.type("name=arQtdCategoria[]", "13")
selenium.typeKeys("name=arQtdCategoria[]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arQtdCategoria[]'])[3]", "3")
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[3]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arQtdCategoria[]'])[7]", "1")
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[7]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arQtdCategoria[]'])[8]", "2")
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[8]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arQtdCategoria[]'])[9]", "27")
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[9]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arQtdCategoria[]'])[15]", "72")
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[15]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arQtdCategoria[]'])[16]", "16")
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[16]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arQtdCategoria[]'])[18]", "56")
selenium.typeKeys("xpath=(//input[@name='arQtdCategoria[]'])[18]", Keys.chord(Keys.ENTER))

selenium.type("xpath=(//input[@name='arRecCategoria[]'])[20]", "41")
selenium.typeKeys("xpath=(//input[@name='arRecCategoria[]'])[20]", Keys.chord(Keys.ENTER))

selenium.typeKeys("xpath=(//input[@name='arRecCategoria[]'])[21]", Keys.chord(Keys.ENTER))

//Informações de Data e Setor de Arrecadação
selenium.type("name=dtArrec", "26/05/2021")
selenium.typeKeys("name=dtArrec", Keys.chord(Keys.ENTER))
selenium.type("name=cdCaixa", "01102")
selenium.typeKeys("name=cdCaixa", Keys.chord(Keys.ENTER))
selenium.type("name=cdSeqCai", "01")
selenium.typeKeys("name=cdSeqCai", Keys.chord(Keys.ENTER))
selenium.type("name=cdSetor", "01")
selenium.typeKeys("name=cdSetor", Keys.chord(Keys.ENTER))

//Informações de depósitos em cofres
selenium.type("name=cdCofre", "908")
selenium.typeKeys("name=cdCofre", Keys.chord(Keys.ENTER))
selenium.type("name=hrCofre", "16:00:26")
selenium.typeKeys("name=hrCofre", Keys.chord(Keys.ENTER))
selenium.type("name=vlCofre", "150")
selenium.typeKeys("name=vlCofre", Keys.chord(Keys.ENTER))
selenium.click("name=btnRegistrarCofre")
Thread.sleep(2000);

selenium.type("name=cdCofre", "908")
selenium.typeKeys("name=cdCofre", Keys.chord(Keys.ENTER))
selenium.type("name=hrCofre", "18:10:34")
selenium.typeKeys("name=hrCofre", Keys.chord(Keys.ENTER))
selenium.type("name=vlCofre", "80")
selenium.typeKeys("name=vlCofre", Keys.chord(Keys.ENTER))
selenium.click("name=btnRegistrarCofre")
Thread.sleep(2000);

//Dispara rotina de gravação do documento
selenium.typeKeys("name=cdCofre", Keys.chord(Keys.DOWN))
selenium.typeKeys("name=gravar", Keys.chord(Keys.ENTER))

// Espera a gravação do documento
Thread.sleep(5000);

//Verifica se o documento foi gravado com sucesso
def content = selenium.getText('//*[@id="Mensagens"]/center/font')
WebUI.verifyMatch(content, '.*Acerto atualizado com sucesso!.*', true)