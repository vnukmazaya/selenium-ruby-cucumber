path = "E:/WRK/chromedriver.exe"
Given(/^Go to the internet browser, open yandex and toggle fullscreen$/) do
  @browser = Selenium::WebDriver.for :chrome, driver_path:path
  url = "https://yandex.ru"
  @browser.manage().window().maximize()
  @browser.navigate.to url
end

When(/^To market$/) do
    @browser.find_element(xpath: "//a[@data-id='market']").click
end

And(/^To electronic$/) do
  @browser.find_element(xpath: "//a[@href='/catalog/54440']").click
end

And(/^To mobile phones$/) do
  @browser.find_element(xpath: "//a[@class='_2qvOOvezty _2x2zBaVN-3 _9qbcyI_fyS' and text()='Мобильные телефоны']").click
end

And(/^Sort for price$/) do
  @browser.find_element(xpath: "//a[@class='link link_theme_major n-filter-sorter__link i-bem link_js_inited' and text()='по цене']").click
end

Then(/^Check$/) do
  sleep(3)
   sumel = @browser.find_elements(xpath: "//div[@class='price']").count()
   mas = @browser.find_elements(xpath: "//div[@class='price']")
   inc = 0
  while inc <= sumel-2  do
    if mas[inc].text <= mas[inc+1].text then
      inc +=1
      @browser.save_screenshot("success.png")
       else
      inc +=1
      @browser.save_screenshot("fail.png")
    end
 end
end