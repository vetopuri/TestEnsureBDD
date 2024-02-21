package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhysicalProgressPage {
	
	WebDriver driver;
	public PhysicalProgressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='SideApplicationNav']/descendant::div[contains(@class,'Container')]/descendant::label[contains(.,'Project')]") WebElement Project;
	public void ClickonProject() {
		Project.click();
	}
	
	@FindBy(xpath="//div[@class=\"SideApplicationNav\"]/descendant::div[contains(@class,\"Container\")]/descendant::label[contains(.,\"Project\")]/ancestor::div[contains(@class,\"TreeItem\")]/following::div[@class=\"Children\"]/descendant::div/label[text()=\"Progress\"]") WebElement Progress;
	public void ClickonProgress() {
		Progress.click();
	}
	@FindBy(xpath="//div[@class=\"SideApplicationNav\"]/descendant::div[contains(@class,\"Container\")]/descendant::label[contains(.,\"Project\")]/ancestor::div[contains(@class,\"TreeItem\")]/following::div[@class=\"Children\"]/descendant::div/label[text()=\"Progress\"]/ancestor::div[contains(@class,\"TreeItem\")]/following::div[contains(@class,\"Children\")][1]/descendant::div/label[text()=\"Generate\"]") WebElement Generate;
	public void ClickonGenerate() {
		Generate.click();
	}
	@FindBy(xpath="//label[normalize-space()=\"Generate Physical Progress by Activity/Cost Object\"]/../../div[contains(@class,\"TitleBar-hasclose\")]/following-sibling::div/div/div/label[contains(.,\"Close\")]") WebElement Close;
	public void ClickonClose() {
		Close.click();
	}
	@FindBy(xpath="//div[@class=\"SideApplicationNav\"]/descendant::div[contains(@class,\"Container\")]/descendant::label[contains(.,\"Project\")]/ancestor::div[contains(@class,\"TreeItem\")]/following::div[@class=\"Children\"]/descendant::div/label[text()=\"Progress\"]/ancestor::div[contains(@class,\"TreeItem\")]/following::div[contains(@class,\"Children\")][1]/descendant::div/label[text()=\"Generate\"]/ancestor::div[contains(@class,\"TreeItem\")]/following::div[contains(@class,\"Children\")]/descendant::label[text()=\"Generate Physical Progress\"]") WebElement GeneratePhysicalProgress;
	public void ClickOnGeneratePhysicalProgress() {
		GeneratePhysicalProgress.click();
	}
	@FindBy(xpath="//div[@class=\"SideApplicationNav\"]/descendant::div[contains(@class,\"Container\")]/descendant::label[contains(.,\"Project\")]/ancestor::div[contains(@class,\"TreeItem\")]/following::div[@class=\"Children\"]/descendant::div/label[text()=\"Progress\"]/ancestor::div[contains(@class,\"TreeItem\")]/following::div[contains(@class,\"Children\")][1]/descendant::div/label[text()=\"Generate\"]/ancestor::div[contains(@class,\"TreeItem\")]/following::div[contains(@class,\"Children\")]/descendant::label[text()=\"Generate Physical Progress\"]/ancestor::div[contains(@class,\"TreeItem\")]/following::div[contains(@class,\"Children\")]/descendant::label[text()=\"Generate Physical Progress by Activity/Cost Object\"]") WebElement GeneratePhysicalProgressbyExtensionorCost;
	public void ClickOnGeneratePhysicalProgressbyExtensionorCost() {
		GeneratePhysicalProgressbyExtensionorCost.click();
	}
	@FindBy(xpath="//td/descendant::div/label[text()=\"Selection Range\"]/ancestor::div[contains(@class,\"FieldSetHeader\")]/following-sibling::div[contains(@class,\"FieldSetContent\")]/descendant::label[contains(text(),\"Project\")]/ancestor::td[contains(@class,\"LabelCell\")]/following-sibling::td/descendant::input/../div") WebElement ProjectCodeSearchButoon;
	public void ClickOnProjectCodeSearchButoon() {
		ProjectCodeSearchButoon.click();
	}
	@FindBy(xpath="(//input[contains(@id,\"tdsls0594m000\") or contains(@id,\"tcmcs0150m000\")  or contains(@id,\"tcmcs0565m000\") or contains(@id,\"tdsls4500m000\") or contains(@id,\"tcmcs0105m000\") or contains(@id,\"tdpur0194m000\") or contains(@id,\"tdpur4500m500\") or contains(@id,\"tdpur0112m000\") or contains(@id,\"tdpur0112m000\") or contains(@id,\"whwmd2500m000\") or contains(@id,\"tccom4515m000\") or contains(@id,\"tfgld0511m000\") or contains(@id,\"tcemm0150m000\") or contains(@id,\"tcemm0130m000\") or contains(@id,\"tccom4530m000\") or contains(@id,\"ttaad1100m000\") or contains(@id, \"tccom4510m000\") or contains(@id, \"tccom4512m000\")or contains(@id, \"tccom4520m000\") or contains(@id,\"bpmdm0101m000\") or contains(@id,\"tdpur2105m000\") or contains(@id,\"tccom0101m000\") or contains(@id,\"tccom4521m000\") or contains(@id,\"tdipu0101m000\") or contains(@id,\"tdipu0181m000\") or contains(@id,\"tfcmg0540m000\") or contains(@id,\"tccom4522m000\") or contains(@id,\"tdisa0181m000\") or contains(@id,\"tcemm1135m000\")or contains(@id,\"tsmdm2100m000\") or contains(@id,\"tsmdm2120m000\") or contains(@id,\"tdsls4500m000\") or contains(@id,\"tdisa0501m000\") or contains(@id,\"tcibd0501m000\")or contains(@id,\"whwmd4500m000\")or contains(@id,\"tsmdm2100m000\")or contains(@id,\"tiedm0110m000\")or contains(@id,\"tiedm1100m000\")or contains(@id,\"tiedm1110m000\")or contains(@id,\"tccom4510m00c\")or contains(@id,\"tcmcs0503m000\") or contains(@id,\"tdext0501m001\") or contains(@id,\"tppdm6100m000\") or contains(@id,\"tppss2100m000\")])[1]") WebElement ProjectCodeTextBox;
	public void EnterValueinProjectCodeTextBox(String ProjectCode) {
		ProjectCodeTextBox.sendKeys(ProjectCode);
	}
	@FindBy(xpath="(//input[contains(@id,\"tdsls0594m000\") or contains(@id,\"tcmcs0150m000\")  or contains(@id,\"tcmcs0565m000\") or contains(@id,\"tdsls4500m000\") or contains(@id,\"tcmcs0105m000\") or contains(@id,\"tdpur0194m000\") or contains(@id,\"tdpur4500m500\") or contains(@id,\"tdpur0112m000\") or contains(@id,\"tdpur0112m000\") or contains(@id,\"whwmd2500m000\") or contains(@id,\"tccom4515m000\") or contains(@id,\"tfgld0511m000\") or contains(@id,\"tcemm0150m000\") or contains(@id,\"tcemm0130m000\") or contains(@id,\"tccom4530m000\") or contains(@id,\"ttaad1100m000\") or contains(@id, \"tccom4510m000\") or contains(@id, \"tccom4512m000\")or contains(@id, \"tccom4520m000\") or contains(@id,\"bpmdm0101m000\") or contains(@id,\"tdpur2105m000\") or contains(@id,\"tccom0101m000\") or contains(@id,\"tccom4521m000\") or contains(@id,\"tdipu0101m000\") or contains(@id,\"tdipu0181m000\") or contains(@id,\"tfcmg0540m000\") or contains(@id,\"tccom4522m000\") or contains(@id,\"tdisa0181m000\") or contains(@id,\"tcemm1135m000\")or contains(@id,\"tsmdm2100m000\") or contains(@id,\"tsmdm2120m000\") or contains(@id,\"tdsls4500m000\") or contains(@id,\"tdisa0501m000\") or contains(@id,\"tcibd0501m000\")or contains(@id,\"whwmd4500m000\")or contains(@id,\"tsmdm2100m000\")or contains(@id,\"tiedm0110m000\")or contains(@id,\"tiedm1100m000\")or contains(@id,\"tiedm1110m000\")or contains(@id,\"tccom4510m00c\")or contains(@id,\"tcmcs0503m000\") or contains(@id,\"tdext0501m001\") or contains(@id,\"tppdm6100m000\") or contains(@id,\"tppss2100m000\")])[2]") WebElement ProjectDescr;
	public void EnterProjecDescr(String ProDescr) {
		ProjectDescr.sendKeys(ProDescr);
	}

	@FindBy(xpath="(//div[contains(@class,\"TextButton\")]/label[contains(.,\"OK\")]/ancestor::div[contains(@class,\"FlowLayoutPanel\")]/../descendant::div[contains(@class,\"WindowContent\")]/../descendant::div[contains(@class,\"HorizontalDataGrid\")]/descendant::div[contains(@class,\"DataSection\")]/descendant::div[contains(@class,\"Button Checkbox\")])[1]") WebElement FirstCheckBox;
	public void ClickOnFirstCheckBox() {
		FirstCheckBox.click();
	}
	@FindBy(xpath="//div[contains(@class,\"TextButton\")]/label[contains(.,\"OK\")]") WebElement OkButton;
	public void ClickOnOkButton() {
		OkButton.click();
	}
	@FindBy(xpath="//td/descendant::div/label[text()=\"Selection Range\"]/ancestor::div[contains(@class,\"FieldSetHeader\")]/following-sibling::div[contains(@class,\"FieldSetContent\")]/descendant::label[contains(text(),\"Activity:\")]/ancestor::td[contains(@class,\"LabelCell\")]/following-sibling::td/descendant::input/../div") WebElement ActvityCodeSearchButoon;
	public void ClickOnActivityCodeSearchButoon() {
		ActvityCodeSearchButoon.click();
	}
	@FindBy(xpath="(//input[contains(@id,\"tdsls0594m000\") or contains(@id,\"tcmcs0150m000\")  or contains(@id,\"tcmcs0565m000\") or contains(@id,\"tdsls4500m000\") or contains(@id,\"tcmcs0105m000\") or contains(@id,\"tdpur0194m000\") or contains(@id,\"tdpur4500m500\") or contains(@id,\"tdpur0112m000\") or contains(@id,\"tdpur0112m000\") or contains(@id,\"whwmd2500m000\") or contains(@id,\"tccom4515m000\") or contains(@id,\"tfgld0511m000\") or contains(@id,\"tcemm0150m000\") or contains(@id,\"tcemm0130m000\") or contains(@id,\"tccom4530m000\") or contains(@id,\"ttaad1100m000\") or contains(@id, \"tccom4510m000\") or contains(@id, \"tccom4512m000\")or contains(@id, \"tccom4520m000\") or contains(@id,\"bpmdm0101m000\") or contains(@id,\"tdpur2105m000\") or contains(@id,\"tccom0101m000\") or contains(@id,\"tccom4521m000\") or contains(@id,\"tdipu0101m000\") or contains(@id,\"tdipu0181m000\") or contains(@id,\"tfcmg0540m000\") or contains(@id,\"tccom4522m000\") or contains(@id,\"tdisa0181m000\") or contains(@id,\"tcemm1135m000\")or contains(@id,\"tsmdm2100m000\") or contains(@id,\"tsmdm2120m000\") or contains(@id,\"tdsls4500m000\") or contains(@id,\"tdisa0501m000\") or contains(@id,\"tcibd0501m000\")or contains(@id,\"whwmd4500m000\")or contains(@id,\"tsmdm2100m000\")or contains(@id,\"tiedm0110m000\")or contains(@id,\"tiedm1100m000\")or contains(@id,\"tiedm1110m000\")or contains(@id,\"tccom4510m00c\")or contains(@id,\"tcmcs0503m000\") or contains(@id,\"tdext0501m001\") or contains(@id,\"tppdm6100m000\") or contains(@id,\"tppss2100m000\")])[1]") WebElement ActvitiyProjectCodeTextBox;
	public void EnterValueinActivityCodeTextBox(String ActivityCode) {
		ActvitiyProjectCodeTextBox.sendKeys(ActivityCode);
	}
	@FindBy(xpath="(//input[contains(@id,\"tdsls0594m000\") or contains(@id,\"tcmcs0150m000\")  or contains(@id,\"tcmcs0565m000\") or contains(@id,\"tdsls4500m000\") or contains(@id,\"tcmcs0105m000\") or contains(@id,\"tdpur0194m000\") or contains(@id,\"tdpur4500m500\") or contains(@id,\"tdpur0112m000\") or contains(@id,\"tdpur0112m000\") or contains(@id,\"whwmd2500m000\") or contains(@id,\"tccom4515m000\") or contains(@id,\"tfgld0511m000\") or contains(@id,\"tcemm0150m000\") or contains(@id,\"tcemm0130m000\") or contains(@id,\"tccom4530m000\") or contains(@id,\"ttaad1100m000\") or contains(@id, \"tccom4510m000\") or contains(@id, \"tccom4512m000\")or contains(@id, \"tccom4520m000\") or contains(@id,\"bpmdm0101m000\") or contains(@id,\"tdpur2105m000\") or contains(@id,\"tccom0101m000\") or contains(@id,\"tccom4521m000\") or contains(@id,\"tdipu0101m000\") or contains(@id,\"tdipu0181m000\") or contains(@id,\"tfcmg0540m000\") or contains(@id,\"tccom4522m000\") or contains(@id,\"tdisa0181m000\") or contains(@id,\"tcemm1135m000\")or contains(@id,\"tsmdm2100m000\") or contains(@id,\"tsmdm2120m000\") or contains(@id,\"tdsls4500m000\") or contains(@id,\"tdisa0501m000\") or contains(@id,\"tcibd0501m000\")or contains(@id,\"whwmd4500m000\")or contains(@id,\"tsmdm2100m000\")or contains(@id,\"tiedm0110m000\")or contains(@id,\"tiedm1100m000\")or contains(@id,\"tiedm1110m000\")or contains(@id,\"tccom4510m00c\")or contains(@id,\"tcmcs0503m000\") or contains(@id,\"tdext0501m001\") or contains(@id,\"tppdm6100m000\") or contains(@id,\"tppss2100m000\")])[2]") WebElement ActvitiyDescrTextBox;
	public void EnterValueinActivityDescrTextBox(String ActivityDesc) {
		ActvitiyDescrTextBox.sendKeys(ActivityDesc);
	}
	@FindBy(xpath="(//*[@class='Button TextButton'])[1]") WebElement GenButton;
	public void ClickOnGenerateButton() {
		GenButton.click();
	}
	@FindBy(xpath="//div[@class=\"SideApplicationNav\"]/descendant::div[contains(@class,\"Container\")]/descendant::label[contains(.,\"Project\")]/ancestor::div[contains(@class,\"TreeItem\")]/following::div[@class=\"Children\"]/descendant::div/label[text()=\"Progress\"]/ancestor::div[contains(@class,\"TreeItem\")]/following::div[contains(@class,\"Children\")][1]/descendant::div/label[text()=\"Physical Progress\"]") WebElement PhysicalProgress;
	public void ClickonPhysicalProgress() {
		PhysicalProgress.click();
	}
	@FindBy(xpath="//div[contains(@id,'-button-std-group.new')]") WebElement Newview;
	public void ClickonNewViewButton() {
		Newview.click();
	}
	@FindBy(xpath="(//label[text()=\"Project:\"]/ancestor::td[contains(@class,\"LabelCell\")]/following-sibling::td/descendant::div[contains(@id,\"lookup-trigger-button\")])[2]") WebElement ProjectSearchButton;
	public WebElement getProjectSearchButton() {
		return ProjectSearchButton;
	}
	@FindBy(xpath="(//label[text()=\"Activity:\"]/ancestor::td[contains(@class,\"LabelCell\")]/following-sibling::td/descendant::div[contains(@id,\"lookup-trigger-button\")])[3]") WebElement ActivitySearchButton;
	public WebElement getActivitySearchButton() {
		return ActivitySearchButton;
	}
	@FindBy(xpath="(//div[contains(@class,\"TitleBar WindowHeader TitleBar-hasclose\")]//following::label[text()=\"Activity Physical Progress\" and (@class=\"Label\")]/following::div[contains(@class,\"ToolbarContainer\")]/descendant::div[contains(@class,\"Button\") and contains(@id,\"button-std-file.save\")])[2]") WebElement SaveButton;
	public WebElement getSaveButton() {
		return SaveButton;
	}
	@FindBy(xpath="(//div[contains(@class,\"TitleBar WindowHeader TitleBar-hasclose\")]//following::label[text()=\"Activity Physical Progress\" and (@class=\"Label\")]/following::div[contains(@class,\"ToolbarContainer\")]/descendant::div[contains(@class,\"Button\") and contains(@id,\"button-std-file.new\")])") WebElement NewButton;
	public WebElement getNewButton() {
		return NewButton;
	}
	@FindBy(xpath="(//*[@class=\"Label TextOutputField\"])[3]") WebElement CumulativeTextBox;
	public WebElement getCumulativeTextBox() {
		return CumulativeTextBox;
	}
	@FindBy(xpath="//*[@id=\"tpppc1560m000-grid-n1-quan-n13-n0-widget\"]") WebElement CumulativeInputTextBox;
	public WebElement getCumulativeInputTextBox() {
		return CumulativeInputTextBox;
	}
	@FindBy(xpath="//label[normalize-space()=\"Activity Physical Progress\"]/../../div[contains(@class,\"TitleBar-hasclose\")]/following-sibling::div/div/div/label[contains(.,\"Approve\")]") WebElement ApproveButton;
	public WebElement getApproveButtton() {
		return ApproveButton;
	}
	@FindBy(xpath="//*[@id=\"tpppc1560m000-grid-n1-select-n0\"]") WebElement PhysicalProgressCheckBox;
	public WebElement getPhysicalProgressCheckBox() {
		return PhysicalProgressCheckBox;
	}
	@FindBy(xpath="//label[normalize-space()=\"Activity Physical Progress\"]/../../div[contains(@class,\"TitleBar-hasclose\")]/following-sibling::div/div/div/label[contains(.,\"References\")]") WebElement ReferencesButtton;
	public WebElement getReferencesButtton() {
		return ReferencesButtton;
	}
	@FindBy(xpath="//tr[contains(@class,\"MenuItem\")]/td/label[normalize-space() = \"Material\"]") WebElement MenuIteamButtton;
	public WebElement getMenuIteamButtton() {
		return MenuIteamButtton;
	}
	@FindBy(xpath="//div[contains(@class,\"TabsScrollPanel\")]/descendant::label[text()=\"Physical Progress by Activity/Material\"]/following-sibling::div[contains(@class,\"Button-transparent Close\")]") WebElement PPAMSessionTabCloseButton;
	public WebElement getPPAMSessionTabCloseButton() {
		return PPAMSessionTabCloseButton;
	}
	
	@FindBy(xpath="//label[normalize-space()=\"No\"]") WebElement PopupNoButton;
	public WebElement getPopupNoButton() {
		return PopupNoButton;
	}
	@FindBy(xpath="//label[normalize-space()=\"Activity Physical Progress\"]/../../div[contains(@class,\"TitleBar-hasclose\")]/following-sibling::div/div/div/label[contains(.,\"Actions\")]") WebElement ActionsButton;
	public WebElement getActionsButton() {
		return ActionsButton;
	}
	@FindBy(xpath="//tr[contains(@class,\"MenuItem\")]/td/label[normalize-space() = \"Unapprove\"]") WebElement getUnapproveButton;
	public WebElement getUnapproveButton() {
		return getUnapproveButton;
	}
	@FindBy(xpath="//*[@id=\"tpppc1560m000-button-std-edit.delete\"]") WebElement DeleteButton;
	public WebElement getDeleteButtton() {
		return DeleteButton;
	}
	@FindBy(xpath="//*[@id=\"dlg-tpppc1560m000-input-button-n0\"]") WebElement PopupYesOrOKButton;
	public WebElement getPopupYesOrOKButton() {
		return PopupYesOrOKButton;
	}
	


	
	
	
}
