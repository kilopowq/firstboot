<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
${message?ifExists}
    <@l.login "/registration"/>
<a href="/registration">Register new user</a>
</@c.page>