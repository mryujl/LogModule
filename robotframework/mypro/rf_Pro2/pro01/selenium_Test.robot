*** Settings ***
Library           SeleniumLibrary

*** Test Cases ***
baidu
    Open Browser    https://www.baidu.com    ie
    #Input Text    id=kw    selenium
    Input Text    xpath=//*[@id='kw']    robot framework
    Click Button    css=#su
    sleep    5
    ${title}    get title
    should contain    ${title}    robot framework_百度搜索
    log    ${title}
    #close Browser
    Close All Browsers

baidu2
    Open Browser    https://www.baidu.com    ie
    #Input Text    id=kw    selenium
    Input Text    xpath=//*[@id='kw']    selenium
    Click Button    css=#su
    sleep    5
    ${title}    get title
    should contain    ${title}    selenium_百度搜索
    log    ${title}
    #close Browser
    Close All Browsers

baidu3
    baidu search    robot framework    robot framework_百度搜索

*** Keywords ***
baidu search
    [Arguments]    ${keyword}    ${assert}
    Open Browser    https://www.baidu.com    ie
    #Input Text    id=kw    selenium
    Input Text    xpath=//*[@id='kw']    ${keyword}
    Click Button    css=#su
    sleep    5
    ${title}    get title
    should contain    ${title}    ${assert}
    log    ${title}
    #close Browser
    Close All Browsers
