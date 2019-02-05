path = "E:/WRK/chromedriver.exe"

Given(/^Go to the internet browser, toggle fullscreen and go to yandex.ru$/) do
  url = "https://yandex.ru"
  @browser = Selenium::WebDriver.for :chrome, driver_path:path
  @browser.manage().window().maximize()
  @browser.navigate.to url
end

When(/^Go to market$/) do
  @browser.find_element(xpath: "//a[@data-id='market']").click
end

And(/^Go electronic$/) do
  @browser.find_element(xpath: "//a[@href='/catalog/54440']").click
end

And(/^Go to headphones$/) do
  @browser.find_element(xpath: "//a[@class='_2qvOOvezty _2x2zBaVN-3 _9qbcyI_fyS' and text()='Наушники и Bluetooth-гарнитуры']").click
end

And(/^To extended search$/) do
  @browser.find_element(xpath: "//span[@class='_28j8Lq95ZZ']").click
end

And(/^More than 5000$/) do
  @browser.find_element(xpath: "//input[@name='glf-pricefrom-var']").send_keys(5000)
end

And(/^Toggle Beats$/) do
  @browser.find_element(xpath: "//label[@for='glf-7893318-8455647']").click
end

And(/^Click OK button$/) do
  @browser.find_element(xpath: "//a[@class='button button_size_l button_theme_pseudo i-bem button_action_show-filtered n-filter-panel-extend__controll-button_size_big button_js_inited']").click
end

And(/^Check 12 elements$/) do
  sumel1 = @browser.find_elements(xpath: "//div[@date-rate>0]").count()

  if sumel1 == 12 then
    @browser.find_element(xpath: "//input[@id='header-search']").send_keys(sumel1,' наушников найдено')
    @browser.save_screenshot("GOOD.png")
  else
    @browser.find_element(xpath: "//input[@id='header-search']").send_keys(sumel1,' наушников найдено')
    @browser.save_screenshot("ERROR.png")
  end
end

Then(/^Find, remember, check and find again$/) do
  @browser.find_elements(xpath: "//div[@date-rate>0]").first().click
  @browser.save_screenshot("find_1st_headphones.png")
  text12 = @browser.find_element(xpath: "//div[@class='n-title__text']").text
  @browser.find_element(xpath: "//input[@id='header-search']").send_keys(text12)
  @browser.save_screenshot("find_headphones.png")
  @browser.find_element(xpath: "//button[@role='button' and @type ='submit']").click
  @browser.find_elements(xpath: "//div[@date-rate>0]").first().click
  @browser.save_screenshot("find_headphones.png")
  text13 = @browser.find_element(xpath: "//div[@class='n-title__text']").text
  if text12 == text13 then
    @browser.save_screenshot("GOOD1.png")
  else
    @browser.save_screenshot("ERROR2.png")
  end
end

