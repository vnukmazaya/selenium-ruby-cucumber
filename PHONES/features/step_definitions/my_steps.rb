path = "E:/WRK/chromedriver.exe"

Given(/^Go to the internet browser and toggle fullscreen$/) do
  @browser = Selenium::WebDriver.for :chrome, driver_path:path
  url = "https://yandex.ru"
  @browser.manage().window().maximize()
  @browser.navigate.to url
end

begin
When(/^Click on market$/) do
  @browser.find_element(xpath: "//a[@data-id='market']").click

end

And(/^Click on electronic$/) do
    @browser.find_element(xpath: "//a[@href='/catalog/54440']").click
end

And(/^Click on mobilePhones$/) do
  @browser.find_element(xpath: "//a[@class='_2qvOOvezty _2x2zBaVN-3 _9qbcyI_fyS' and text()='Мобильные телефоны']").click
end

And(/^Go to extended search$/) do
  @browser.find_element(xpath: "//span[@class='_28j8Lq95ZZ']").click
end

And(/^More than 20000$/) do
  @browser.find_element(xpath: "//input[@name='glf-pricefrom-var']").send_keys(20000)
end

And(/^Toggle Apple and Samsung$/) do
  @browser.find_element(xpath: "//label[@for='glf-7893318-153043']").click
  @browser.find_element(xpath: "//label[@for='glf-7893318-153061']").click
end

And(/^OK button$/) do
  @browser.find_element(xpath: "//a[@class='button button_size_l button_theme_pseudo i-bem button_action_show-filtered n-filter-panel-extend__controll-button_size_big button_js_inited']").click
end

And(/^12 elements$/) do
  sumel1 = @browser.find_elements(xpath: "//div[@date-rate>0]").count()

  if sumel1 == 12 then
     @browser.find_element(xpath: "//input[@id='header-search']").send_keys(sumel1,' Телефонов найдено')
     @browser.save_screenshot("GOOD.png")
  else
    @browser.find_element(xpath: "//input[@id='header-search']").send_keys(sumel1,' Телефонов найдено')
    @browser.save_screenshot("ERROR.png")
  end
end

Then(/^Remember, search and check 1st element$/) do
  @browser.find_elements(xpath: "//div[@date-rate>0]").first().click
  @browser.save_screenshot("find_phone1.png")
  text12 = @browser.find_element(xpath: "//div[@class='n-title__text']").text
  @browser.find_element(xpath: "//input[@id='header-search']").send_keys(text12)
  @browser.save_screenshot("find_phone2.png")
  @browser.find_element(xpath: "//button[@role='button' and @type ='submit']").click
  @browser.find_elements(xpath: "//div[@date-rate>0]").first().click
  @browser.save_screenshot("find_phone3.png")
  text13 = @browser.find_element(xpath: "//div[@class='n-title__text']").text
  if text12 == text13 then
   @browser.save_screenshot("GOOD1.png")
   else
    @browser.save_screenshot("ERROR2.png")
  end
 end
end