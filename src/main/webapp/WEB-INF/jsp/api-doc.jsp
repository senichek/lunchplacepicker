<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge"><![endif]-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="generator" content="Asciidoctor 1.5.6.1">
    <title>Greeting REST Service API Guide</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,300italic,400,400italic,600,600italic%7CNoto+Serif:400,400italic,700,700italic%7CDroid+Sans+Mono:400,700">
    <style>
        /* Asciidoctor default stylesheet | MIT License | http://asciidoctor.org */
        /* Remove comment around @import statement below when using as a custom stylesheet */
        /*@import "https://fonts.googleapis.com/css?family=Open+Sans:300,300italic,400,400italic,600,600italic%7CNoto+Serif:400,400italic,700,700italic%7CDroid+Sans+Mono:400,700";*/
        article,aside,details,figcaption,figure,footer,header,hgroup,main,nav,section,summary{display:block}
        audio,canvas,video{display:inline-block}
        audio:not([controls]){display:none;height:0}
        [hidden],template{display:none}
        script{display:none!important}
        html{font-family:sans-serif;-ms-text-size-adjust:100%;-webkit-text-size-adjust:100%}
        a{background:transparent}
        a:focus{outline:thin dotted}
        a:active,a:hover{outline:0}
        h1{font-size:2em;margin:.67em 0}
        abbr[title]{border-bottom:1px dotted}
        b,strong{font-weight:bold}
        dfn{font-style:italic}
        hr{-moz-box-sizing:content-box;box-sizing:content-box;height:0}
        mark{background:#ff0;color:#000}
        code,kbd,pre,samp{font-family:monospace;font-size:1em}
        pre{white-space:pre-wrap}
        q{quotes:"\201C" "\201D" "\2018" "\2019"}
        small{font-size:80%}
        sub,sup{font-size:75%;line-height:0;position:relative;vertical-align:baseline}
        sup{top:-.5em}
        sub{bottom:-.25em}
        img{border:0}
        svg:not(:root){overflow:hidden}
        figure{margin:0}
        fieldset{border:1px solid silver;margin:0 2px;padding:.35em .625em .75em}
        legend{border:0;padding:0}
        button,input,select,textarea{font-family:inherit;font-size:100%;margin:0}
        button,input{line-height:normal}
        button,select{text-transform:none}
        button,html input[type="button"],input[type="reset"],input[type="submit"]{-webkit-appearance:button;cursor:pointer}
        button[disabled],html input[disabled]{cursor:default}
        input[type="checkbox"],input[type="radio"]{box-sizing:border-box;padding:0}
        input[type="search"]{-webkit-appearance:textfield;-moz-box-sizing:content-box;-webkit-box-sizing:content-box;box-sizing:content-box}
        input[type="search"]::-webkit-search-cancel-button,input[type="search"]::-webkit-search-decoration{-webkit-appearance:none}
        button::-moz-focus-inner,input::-moz-focus-inner{border:0;padding:0}
        textarea{overflow:auto;vertical-align:top}
        table{border-collapse:collapse;border-spacing:0}
        *,*:before,*:after{-moz-box-sizing:border-box;-webkit-box-sizing:border-box;box-sizing:border-box}
        html,body{font-size:100%}
        body{background:#fff;color:rgba(0,0,0,.8);padding:0;margin:0;font-family:"Noto Serif","DejaVu Serif",serif;font-weight:400;font-style:normal;line-height:1;position:relative;cursor:auto;tab-size:4;-moz-osx-font-smoothing:grayscale;-webkit-font-smoothing:antialiased}
        a:hover{cursor:pointer}
        img,object,embed{max-width:100%;height:auto}
        object,embed{height:100%}
        img{-ms-interpolation-mode:bicubic}
        .left{float:left!important}
        .right{float:right!important}
        .text-left{text-align:left!important}
        .text-right{text-align:right!important}
        .text-center{text-align:center!important}
        .text-justify{text-align:justify!important}
        .hide{display:none}
        img,object,svg{display:inline-block;vertical-align:middle}
        textarea{height:auto;min-height:50px}
        select{width:100%}
        .center{margin-left:auto;margin-right:auto}
        .spread{width:100%}
        p.lead,.paragraph.lead>p,#preamble>.sectionbody>.paragraph:first-of-type p{font-size:1.21875em;line-height:1.6}
        .subheader,.admonitionblock td.content>.title,.audioblock>.title,.exampleblock>.title,.imageblock>.title,.listingblock>.title,.literalblock>.title,.stemblock>.title,.openblock>.title,.paragraph>.title,.quoteblock>.title,table.tableblock>.title,.verseblock>.title,.videoblock>.title,.dlist>.title,.olist>.title,.ulist>.title,.qlist>.title,.hdlist>.title{line-height:1.45;color:#7a2518;font-weight:400;margin-top:0;margin-bottom:.25em}
        div,dl,dt,dd,ul,ol,li,h1,h2,h3,#toctitle,.sidebarblock>.content>.title,h4,h5,h6,pre,form,p,blockquote,th,td{margin:0;padding:0;direction:ltr}
        a{color:#2156a5;text-decoration:underline;line-height:inherit}
        a:hover,a:focus{color:#1d4b8f}
        a img{border:none}
        p{font-family:inherit;font-weight:400;font-size:1em;line-height:1.6;margin-bottom:1.25em;text-rendering:optimizeLegibility}
        p aside{font-size:.875em;line-height:1.35;font-style:italic}
        h1,h2,h3,#toctitle,.sidebarblock>.content>.title,h4,h5,h6{font-family:"Open Sans","DejaVu Sans",sans-serif;font-weight:300;font-style:normal;color:#ba3925;text-rendering:optimizeLegibility;margin-top:1em;margin-bottom:.5em;line-height:1.0125em}
        h1 small,h2 small,h3 small,#toctitle small,.sidebarblock>.content>.title small,h4 small,h5 small,h6 small{font-size:60%;color:#e99b8f;line-height:0}
        h1{font-size:2.125em}
        h2{font-size:1.6875em}
        h3,#toctitle,.sidebarblock>.content>.title{font-size:1.375em}
        h4,h5{font-size:1.125em}
        h6{font-size:1em}
        hr{border:solid #ddddd8;border-width:1px 0 0;clear:both;margin:1.25em 0 1.1875em;height:0}
        em,i{font-style:italic;line-height:inherit}
        strong,b{font-weight:bold;line-height:inherit}
        small{font-size:60%;line-height:inherit}
        code{font-family:"Droid Sans Mono","DejaVu Sans Mono",monospace;font-weight:400;color:rgba(0,0,0,.9)}
        ul,ol,dl{font-size:1em;line-height:1.6;margin-bottom:1.25em;list-style-position:outside;font-family:inherit}
        ul,ol{margin-left:1.5em}
        ul li ul,ul li ol{margin-left:1.25em;margin-bottom:0;font-size:1em}
        ul.square li ul,ul.circle li ul,ul.disc li ul{list-style:inherit}
        ul.square{list-style-type:square}
        ul.circle{list-style-type:circle}
        ul.disc{list-style-type:disc}
        ol li ul,ol li ol{margin-left:1.25em;margin-bottom:0}
        dl dt{margin-bottom:.3125em;font-weight:bold}
        dl dd{margin-bottom:1.25em}
        abbr,acronym{text-transform:uppercase;font-size:90%;color:rgba(0,0,0,.8);border-bottom:1px dotted #ddd;cursor:help}
        abbr{text-transform:none}
        blockquote{margin:0 0 1.25em;padding:.5625em 1.25em 0 1.1875em;border-left:1px solid #ddd}
        blockquote cite{display:block;font-size:.9375em;color:rgba(0,0,0,.6)}
        blockquote cite:before{content:"\2014 \0020"}
        blockquote cite a,blockquote cite a:visited{color:rgba(0,0,0,.6)}
        blockquote,blockquote p{line-height:1.6;color:rgba(0,0,0,.85)}
        @media only screen and (min-width:768px){h1,h2,h3,#toctitle,.sidebarblock>.content>.title,h4,h5,h6{line-height:1.2}
            h1{font-size:2.75em}
            h2{font-size:2.3125em}
            h3,#toctitle,.sidebarblock>.content>.title{font-size:1.6875em}
            h4{font-size:1.4375em}}
        table{background:#fff;margin-bottom:1.25em;border:solid 1px #dedede}
        table thead,table tfoot{background:#f7f8f7;font-weight:bold}
        table thead tr th,table thead tr td,table tfoot tr th,table tfoot tr td{padding:.5em .625em .625em;font-size:inherit;color:rgba(0,0,0,.8);text-align:left}
        table tr th,table tr td{padding:.5625em .625em;font-size:inherit;color:rgba(0,0,0,.8)}
        table tr.even,table tr.alt,table tr:nth-of-type(even){background:#f8f8f7}
        table thead tr th,table tfoot tr th,table tbody tr td,table tr td,table tfoot tr td{display:table-cell;line-height:1.6}
        h1,h2,h3,#toctitle,.sidebarblock>.content>.title,h4,h5,h6{line-height:1.2;word-spacing:-.05em}
        h1 strong,h2 strong,h3 strong,#toctitle strong,.sidebarblock>.content>.title strong,h4 strong,h5 strong,h6 strong{font-weight:400}
        .clearfix:before,.clearfix:after,.float-group:before,.float-group:after{content:" ";display:table}
        .clearfix:after,.float-group:after{clear:both}
        *:not(pre)>code{font-size:.9375em;font-style:normal!important;letter-spacing:0;padding:.1em .5ex;word-spacing:-.15em;background-color:#f7f7f8;-webkit-border-radius:4px;border-radius:4px;line-height:1.45;text-rendering:optimizeSpeed;word-wrap:break-word}
        *:not(pre)>code.nobreak{word-wrap:normal}
        *:not(pre)>code.nowrap{white-space:nowrap}
        pre,pre>code{line-height:1.45;color:rgba(0,0,0,.9);font-family:"Droid Sans Mono","DejaVu Sans Mono",monospace;font-weight:400;text-rendering:optimizeSpeed}
        em em{font-style:normal}
        strong strong{font-weight:400}
        .keyseq{color:rgba(51,51,51,.8)}
        kbd{font-family:"Droid Sans Mono","DejaVu Sans Mono",monospace;display:inline-block;color:rgba(0,0,0,.8);font-size:.65em;line-height:1.45;background-color:#f7f7f7;border:1px solid #ccc;-webkit-border-radius:3px;border-radius:3px;-webkit-box-shadow:0 1px 0 rgba(0,0,0,.2),0 0 0 .1em white inset;box-shadow:0 1px 0 rgba(0,0,0,.2),0 0 0 .1em #fff inset;margin:0 .15em;padding:.2em .5em;vertical-align:middle;position:relative;top:-.1em;white-space:nowrap}
        .keyseq kbd:first-child{margin-left:0}
        .keyseq kbd:last-child{margin-right:0}
        .menuseq,.menuref{color:#000}
        .menuseq b:not(.caret),.menuref{font-weight:inherit}
        .menuseq{word-spacing:-.02em}
        .menuseq b.caret{font-size:1.25em;line-height:.8}
        .menuseq i.caret{font-weight:bold;text-align:center;width:.45em}
        b.button:before,b.button:after{position:relative;top:-1px;font-weight:400}
        b.button:before{content:"[";padding:0 3px 0 2px}
        b.button:after{content:"]";padding:0 2px 0 3px}
        p a>code:hover{color:rgba(0,0,0,.9)}
        #header,#content,#footnotes,#footer{width:100%;margin-left:auto;margin-right:auto;margin-top:0;margin-bottom:0;max-width:62.5em;*zoom:1;position:relative;padding-left:.9375em;padding-right:.9375em}
        #header:before,#header:after,#content:before,#content:after,#footnotes:before,#footnotes:after,#footer:before,#footer:after{content:" ";display:table}
        #header:after,#content:after,#footnotes:after,#footer:after{clear:both}
        #content{margin-top:1.25em}
        #content:before{content:none}
        #header>h1:first-child{color:rgba(0,0,0,.85);margin-top:2.25rem;margin-bottom:0}
        #header>h1:first-child+#toc{margin-top:8px;border-top:1px solid #ddddd8}
        #header>h1:only-child,body.toc2 #header>h1:nth-last-child(2){border-bottom:1px solid #ddddd8;padding-bottom:8px}
        #header .details{border-bottom:1px solid #ddddd8;line-height:1.45;padding-top:.25em;padding-bottom:.25em;padding-left:.25em;color:rgba(0,0,0,.6);display:-ms-flexbox;display:-webkit-flex;display:flex;-ms-flex-flow:row wrap;-webkit-flex-flow:row wrap;flex-flow:row wrap}
        #header .details span:first-child{margin-left:-.125em}
        #header .details span.email a{color:rgba(0,0,0,.85)}
        #header .details br{display:none}
        #header .details br+span:before{content:"\00a0\2013\00a0"}
        #header .details br+span.author:before{content:"\00a0\22c5\00a0";color:rgba(0,0,0,.85)}
        #header .details br+span#revremark:before{content:"\00a0|\00a0"}
        #header #revnumber{text-transform:capitalize}
        #header #revnumber:after{content:"\00a0"}
        #content>h1:first-child:not([class]){color:rgba(0,0,0,.85);border-bottom:1px solid #ddddd8;padding-bottom:8px;margin-top:0;padding-top:1rem;margin-bottom:1.25rem}
        #toc{border-bottom:1px solid #efefed;padding-bottom:.5em}
        #toc>ul{margin-left:.125em}
        #toc ul.sectlevel0>li>a{font-style:italic}
        #toc ul.sectlevel0 ul.sectlevel1{margin:.5em 0}
        #toc ul{font-family:"Open Sans","DejaVu Sans",sans-serif;list-style-type:none}
        #toc li{line-height:1.3334;margin-top:.3334em}
        #toc a{text-decoration:none}
        #toc a:active{text-decoration:underline}
        #toctitle{color:#7a2518;font-size:1.2em}
        @media only screen and (min-width:768px){#toctitle{font-size:1.375em}
            body.toc2{padding-left:15em;padding-right:0}
            #toc.toc2{margin-top:0!important;background-color:#f8f8f7;position:fixed;width:15em;left:0;top:0;border-right:1px solid #efefed;border-top-width:0!important;border-bottom-width:0!important;z-index:1000;padding:1.25em 1em;height:100%;overflow:auto}
            #toc.toc2 #toctitle{margin-top:0;margin-bottom:.8rem;font-size:1.2em}
            #toc.toc2>ul{font-size:.9em;margin-bottom:0}
            #toc.toc2 ul ul{margin-left:0;padding-left:1em}
            #toc.toc2 ul.sectlevel0 ul.sectlevel1{padding-left:0;margin-top:.5em;margin-bottom:.5em}
            body.toc2.toc-right{padding-left:0;padding-right:15em}
            body.toc2.toc-right #toc.toc2{border-right-width:0;border-left:1px solid #efefed;left:auto;right:0}}
        @media only screen and (min-width:1280px){body.toc2{padding-left:20em;padding-right:0}
            #toc.toc2{width:20em}
            #toc.toc2 #toctitle{font-size:1.375em}
            #toc.toc2>ul{font-size:.95em}
            #toc.toc2 ul ul{padding-left:1.25em}
            body.toc2.toc-right{padding-left:0;padding-right:20em}}
        #content #toc{border-style:solid;border-width:1px;border-color:#e0e0dc;margin-bottom:1.25em;padding:1.25em;background:#f8f8f7;-webkit-border-radius:4px;border-radius:4px}
        #content #toc>:first-child{margin-top:0}
        #content #toc>:last-child{margin-bottom:0}
        #footer{max-width:100%;background-color:rgba(0,0,0,.8);padding:1.25em}
        #footer-text{color:rgba(255,255,255,.8);line-height:1.44}
        .sect1{padding-bottom:.625em}
        @media only screen and (min-width:768px){.sect1{padding-bottom:1.25em}}
        .sect1+.sect1{border-top:1px solid #efefed}
        #content h1>a.anchor,h2>a.anchor,h3>a.anchor,#toctitle>a.anchor,.sidebarblock>.content>.title>a.anchor,h4>a.anchor,h5>a.anchor,h6>a.anchor{position:absolute;z-index:1001;width:1.5ex;margin-left:-1.5ex;display:block;text-decoration:none!important;visibility:hidden;text-align:center;font-weight:400}
        #content h1>a.anchor:before,h2>a.anchor:before,h3>a.anchor:before,#toctitle>a.anchor:before,.sidebarblock>.content>.title>a.anchor:before,h4>a.anchor:before,h5>a.anchor:before,h6>a.anchor:before{content:"\00A7";font-size:.85em;display:block;padding-top:.1em}
        #content h1:hover>a.anchor,#content h1>a.anchor:hover,h2:hover>a.anchor,h2>a.anchor:hover,h3:hover>a.anchor,#toctitle:hover>a.anchor,.sidebarblock>.content>.title:hover>a.anchor,h3>a.anchor:hover,#toctitle>a.anchor:hover,.sidebarblock>.content>.title>a.anchor:hover,h4:hover>a.anchor,h4>a.anchor:hover,h5:hover>a.anchor,h5>a.anchor:hover,h6:hover>a.anchor,h6>a.anchor:hover{visibility:visible}
        #content h1>a.link,h2>a.link,h3>a.link,#toctitle>a.link,.sidebarblock>.content>.title>a.link,h4>a.link,h5>a.link,h6>a.link{color:#ba3925;text-decoration:none}
        #content h1>a.link:hover,h2>a.link:hover,h3>a.link:hover,#toctitle>a.link:hover,.sidebarblock>.content>.title>a.link:hover,h4>a.link:hover,h5>a.link:hover,h6>a.link:hover{color:#a53221}
        .audioblock,.imageblock,.literalblock,.listingblock,.stemblock,.videoblock{margin-bottom:1.25em}
        .admonitionblock td.content>.title,.audioblock>.title,.exampleblock>.title,.imageblock>.title,.listingblock>.title,.literalblock>.title,.stemblock>.title,.openblock>.title,.paragraph>.title,.quoteblock>.title,table.tableblock>.title,.verseblock>.title,.videoblock>.title,.dlist>.title,.olist>.title,.ulist>.title,.qlist>.title,.hdlist>.title{text-rendering:optimizeLegibility;text-align:left;font-family:"Noto Serif","DejaVu Serif",serif;font-size:1rem;font-style:italic}
        table.tableblock>caption.title{white-space:nowrap;overflow:visible;max-width:0}
        .paragraph.lead>p,#preamble>.sectionbody>.paragraph:first-of-type p{color:rgba(0,0,0,.85)}
        table.tableblock #preamble>.sectionbody>.paragraph:first-of-type p{font-size:inherit}
        .admonitionblock>table{border-collapse:separate;border:0;background:none;width:100%}
        .admonitionblock>table td.icon{text-align:center;width:80px}
        .admonitionblock>table td.icon img{max-width:initial}
        .admonitionblock>table td.icon .title{font-weight:bold;font-family:"Open Sans","DejaVu Sans",sans-serif;text-transform:uppercase}
        .admonitionblock>table td.content{padding-left:1.125em;padding-right:1.25em;border-left:1px solid #ddddd8;color:rgba(0,0,0,.6)}
        .admonitionblock>table td.content>:last-child>:last-child{margin-bottom:0}
        .exampleblock>.content{border-style:solid;border-width:1px;border-color:#e6e6e6;margin-bottom:1.25em;padding:1.25em;background:#fff;-webkit-border-radius:4px;border-radius:4px}
        .exampleblock>.content>:first-child{margin-top:0}
        .exampleblock>.content>:last-child{margin-bottom:0}
        .sidebarblock{border-style:solid;border-width:1px;border-color:#e0e0dc;margin-bottom:1.25em;padding:1.25em;background:#f8f8f7;-webkit-border-radius:4px;border-radius:4px}
        .sidebarblock>:first-child{margin-top:0}
        .sidebarblock>:last-child{margin-bottom:0}
        .sidebarblock>.content>.title{color:#7a2518;margin-top:0;text-align:center}
        .exampleblock>.content>:last-child>:last-child,.exampleblock>.content .olist>ol>li:last-child>:last-child,.exampleblock>.content .ulist>ul>li:last-child>:last-child,.exampleblock>.content .qlist>ol>li:last-child>:last-child,.sidebarblock>.content>:last-child>:last-child,.sidebarblock>.content .olist>ol>li:last-child>:last-child,.sidebarblock>.content .ulist>ul>li:last-child>:last-child,.sidebarblock>.content .qlist>ol>li:last-child>:last-child{margin-bottom:0}
        .literalblock pre,.listingblock pre:not(.highlight),.listingblock pre[class="highlight"],.listingblock pre[class^="highlight "],.listingblock pre.CodeRay,.listingblock pre.prettyprint{background:#f7f7f8}
        .sidebarblock .literalblock pre,.sidebarblock .listingblock pre:not(.highlight),.sidebarblock .listingblock pre[class="highlight"],.sidebarblock .listingblock pre[class^="highlight "],.sidebarblock .listingblock pre.CodeRay,.sidebarblock .listingblock pre.prettyprint{background:#f2f1f1}
        .literalblock pre,.literalblock pre[class],.listingblock pre,.listingblock pre[class]{-webkit-border-radius:4px;border-radius:4px;word-wrap:break-word;padding:1em;font-size:.8125em}
        .literalblock pre.nowrap,.literalblock pre[class].nowrap,.listingblock pre.nowrap,.listingblock pre[class].nowrap{overflow-x:auto;white-space:pre;word-wrap:normal}
        @media only screen and (min-width:768px){.literalblock pre,.literalblock pre[class],.listingblock pre,.listingblock pre[class]{font-size:.90625em}}
        @media only screen and (min-width:1280px){.literalblock pre,.literalblock pre[class],.listingblock pre,.listingblock pre[class]{font-size:1em}}
        .literalblock.output pre{color:#f7f7f8;background-color:rgba(0,0,0,.9)}
        .listingblock pre.highlightjs{padding:0}
        .listingblock pre.highlightjs>code{padding:1em;-webkit-border-radius:4px;border-radius:4px}
        .listingblock pre.prettyprint{border-width:0}
        .listingblock>.content{position:relative}
        .listingblock code[data-lang]:before{display:none;content:attr(data-lang);position:absolute;font-size:.75em;top:.425rem;right:.5rem;line-height:1;text-transform:uppercase;color:#999}
        .listingblock:hover code[data-lang]:before{display:block}
        .listingblock.terminal pre .command:before{content:attr(data-prompt);padding-right:.5em;color:#999}
        .listingblock.terminal pre .command:not([data-prompt]):before{content:"$"}
        table.pyhltable{border-collapse:separate;border:0;margin-bottom:0;background:none}
        table.pyhltable td{vertical-align:top;padding-top:0;padding-bottom:0;line-height:1.45}
        table.pyhltable td.code{padding-left:.75em;padding-right:0}
        pre.pygments .lineno,table.pyhltable td:not(.code){color:#999;padding-left:0;padding-right:.5em;border-right:1px solid #ddddd8}
        pre.pygments .lineno{display:inline-block;margin-right:.25em}
        table.pyhltable .linenodiv{background:none!important;padding-right:0!important}
        .quoteblock{margin:0 1em 1.25em 1.5em;display:table}
        .quoteblock>.title{margin-left:-1.5em;margin-bottom:.75em}
        .quoteblock blockquote,.quoteblock blockquote p{color:rgba(0,0,0,.85);font-size:1.15rem;line-height:1.75;word-spacing:.1em;letter-spacing:0;font-style:italic;text-align:justify}
        .quoteblock blockquote{margin:0;padding:0;border:0}
        .quoteblock blockquote:before{content:"\201c";float:left;font-size:2.75em;font-weight:bold;line-height:.6em;margin-left:-.6em;color:#7a2518;text-shadow:0 1px 2px rgba(0,0,0,.1)}
        .quoteblock blockquote>.paragraph:last-child p{margin-bottom:0}
        .quoteblock .attribution{margin-top:.5em;margin-right:.5ex;text-align:right}
        .quoteblock .quoteblock{margin-left:0;margin-right:0;padding:.5em 0;border-left:3px solid rgba(0,0,0,.6)}
        .quoteblock .quoteblock blockquote{padding:0 0 0 .75em}
        .quoteblock .quoteblock blockquote:before{display:none}
        .verseblock{margin:0 1em 1.25em 1em}
        .verseblock pre{font-family:"Open Sans","DejaVu Sans",sans;font-size:1.15rem;color:rgba(0,0,0,.85);font-weight:300;text-rendering:optimizeLegibility}
        .verseblock pre strong{font-weight:400}
        .verseblock .attribution{margin-top:1.25rem;margin-left:.5ex}
        .quoteblock .attribution,.verseblock .attribution{font-size:.9375em;line-height:1.45;font-style:italic}
        .quoteblock .attribution br,.verseblock .attribution br{display:none}
        .quoteblock .attribution cite,.verseblock .attribution cite{display:block;letter-spacing:-.025em;color:rgba(0,0,0,.6)}
        .quoteblock.abstract{margin:0 0 1.25em 0;display:block}
        .quoteblock.abstract blockquote,.quoteblock.abstract blockquote p{text-align:left;word-spacing:0}
        .quoteblock.abstract blockquote:before,.quoteblock.abstract blockquote p:first-of-type:before{display:none}
        table.tableblock{max-width:100%;border-collapse:separate}
        table.tableblock td>.paragraph:last-child p>p:last-child,table.tableblock th>p:last-child,table.tableblock td>p:last-child{margin-bottom:0}
        table.tableblock,th.tableblock,td.tableblock{border:0 solid #dedede}
        table.grid-all>thead>tr>.tableblock,table.grid-all>tbody>tr>.tableblock{border-width:0 1px 1px 0}
        table.grid-all>tfoot>tr>.tableblock{border-width:1px 1px 0 0}
        table.grid-cols>*>tr>.tableblock{border-width:0 1px 0 0}
        table.grid-rows>thead>tr>.tableblock,table.grid-rows>tbody>tr>.tableblock{border-width:0 0 1px 0}
        table.grid-rows>tfoot>tr>.tableblock{border-width:1px 0 0 0}
        table.grid-all>*>tr>.tableblock:last-child,table.grid-cols>*>tr>.tableblock:last-child{border-right-width:0}
        table.grid-all>tbody>tr:last-child>.tableblock,table.grid-all>thead:last-child>tr>.tableblock,table.grid-rows>tbody>tr:last-child>.tableblock,table.grid-rows>thead:last-child>tr>.tableblock{border-bottom-width:0}
        table.frame-all{border-width:1px}
        table.frame-sides{border-width:0 1px}
        table.frame-topbot{border-width:1px 0}
        th.halign-left,td.halign-left{text-align:left}
        th.halign-right,td.halign-right{text-align:right}
        th.halign-center,td.halign-center{text-align:center}
        th.valign-top,td.valign-top{vertical-align:top}
        th.valign-bottom,td.valign-bottom{vertical-align:bottom}
        th.valign-middle,td.valign-middle{vertical-align:middle}
        table thead th,table tfoot th{font-weight:bold}
        tbody tr th{display:table-cell;line-height:1.6;background:#f7f8f7}
        tbody tr th,tbody tr th p,tfoot tr th,tfoot tr th p{color:rgba(0,0,0,.8);font-weight:bold}
        p.tableblock>code:only-child{background:none;padding:0}
        p.tableblock{font-size:1em}
        td>div.verse{white-space:pre}
        ol{margin-left:1.75em}
        ul li ol{margin-left:1.5em}
        dl dd{margin-left:1.125em}
        dl dd:last-child,dl dd:last-child>:last-child{margin-bottom:0}
        ol>li p,ul>li p,ul dd,ol dd,.olist .olist,.ulist .ulist,.ulist .olist,.olist .ulist{margin-bottom:.625em}
        ul.checklist,ul.none,ol.none,ul.no-bullet,ol.no-bullet,ol.unnumbered,ul.unstyled,ol.unstyled{list-style-type:none}
        ul.no-bullet,ol.no-bullet,ol.unnumbered{margin-left:.625em}
        ul.unstyled,ol.unstyled{margin-left:0}
        ul.checklist{margin-left:.625em}
        ul.checklist li>p:first-child>.fa-square-o:first-child,ul.checklist li>p:first-child>.fa-check-square-o:first-child{width:1.25em;font-size:.8em;position:relative;bottom:.125em}
        ul.checklist li>p:first-child>input[type="checkbox"]:first-child{margin-right:.25em}
        ul.inline{margin:0 auto .625em auto;margin-left:-1.375em;margin-right:0;padding:0;list-style:none;overflow:hidden}
        ul.inline>li{list-style:none;float:left;margin-left:1.375em;display:block}
        ul.inline>li>*{display:block}
        .unstyled dl dt{font-weight:400;font-style:normal}
        ol.arabic{list-style-type:decimal}
        ol.decimal{list-style-type:decimal-leading-zero}
        ol.loweralpha{list-style-type:lower-alpha}
        ol.upperalpha{list-style-type:upper-alpha}
        ol.lowerroman{list-style-type:lower-roman}
        ol.upperroman{list-style-type:upper-roman}
        ol.lowergreek{list-style-type:lower-greek}
        .hdlist>table,.colist>table{border:0;background:none}
        .hdlist>table>tbody>tr,.colist>table>tbody>tr{background:none}
        td.hdlist1,td.hdlist2{vertical-align:top;padding:0 .625em}
        td.hdlist1{font-weight:bold;padding-bottom:1.25em}
        .literalblock+.colist,.listingblock+.colist{margin-top:-.5em}
        .colist>table tr>td:first-of-type{padding:.4em .75em 0 .75em;line-height:1;vertical-align:top}
        .colist>table tr>td:first-of-type img{max-width:initial}
        .colist>table tr>td:last-of-type{padding:.25em 0}
        .thumb,.th{line-height:0;display:inline-block;border:solid 4px #fff;-webkit-box-shadow:0 0 0 1px #ddd;box-shadow:0 0 0 1px #ddd}
        .imageblock.left,.imageblock[style*="float: left"]{margin:.25em .625em 1.25em 0}
        .imageblock.right,.imageblock[style*="float: right"]{margin:.25em 0 1.25em .625em}
        .imageblock>.title{margin-bottom:0}
        .imageblock.thumb,.imageblock.th{border-width:6px}
        .imageblock.thumb>.title,.imageblock.th>.title{padding:0 .125em}
        .image.left,.image.right{margin-top:.25em;margin-bottom:.25em;display:inline-block;line-height:0}
        .image.left{margin-right:.625em}
        .image.right{margin-left:.625em}
        a.image{text-decoration:none;display:inline-block}
        a.image object{pointer-events:none}
        sup.footnote,sup.footnoteref{font-size:.875em;position:static;vertical-align:super}
        sup.footnote a,sup.footnoteref a{text-decoration:none}
        sup.footnote a:active,sup.footnoteref a:active{text-decoration:underline}
        #footnotes{padding-top:.75em;padding-bottom:.75em;margin-bottom:.625em}
        #footnotes hr{width:20%;min-width:6.25em;margin:-.25em 0 .75em 0;border-width:1px 0 0 0}
        #footnotes .footnote{padding:0 .375em 0 .225em;line-height:1.3334;font-size:.875em;margin-left:1.2em;text-indent:-1.05em;margin-bottom:.2em}
        #footnotes .footnote a:first-of-type{font-weight:bold;text-decoration:none}
        #footnotes .footnote:last-of-type{margin-bottom:0}
        #content #footnotes{margin-top:-.625em;margin-bottom:0;padding:.75em 0}
        .gist .file-data>table{border:0;background:#fff;width:100%;margin-bottom:0}
        .gist .file-data>table td.line-data{width:99%}
        div.unbreakable{page-break-inside:avoid}
        .big{font-size:larger}
        .small{font-size:smaller}
        .underline{text-decoration:underline}
        .overline{text-decoration:overline}
        .line-through{text-decoration:line-through}
        .aqua{color:#00bfbf}
        .aqua-background{background-color:#00fafa}
        .black{color:#000}
        .black-background{background-color:#000}
        .blue{color:#0000bf}
        .blue-background{background-color:#0000fa}
        .fuchsia{color:#bf00bf}
        .fuchsia-background{background-color:#fa00fa}
        .gray{color:#606060}
        .gray-background{background-color:#7d7d7d}
        .green{color:#006000}
        .green-background{background-color:#007d00}
        .lime{color:#00bf00}
        .lime-background{background-color:#00fa00}
        .maroon{color:#600000}
        .maroon-background{background-color:#7d0000}
        .navy{color:#000060}
        .navy-background{background-color:#00007d}
        .olive{color:#606000}
        .olive-background{background-color:#7d7d00}
        .purple{color:#600060}
        .purple-background{background-color:#7d007d}
        .red{color:#bf0000}
        .red-background{background-color:#fa0000}
        .silver{color:#909090}
        .silver-background{background-color:#bcbcbc}
        .teal{color:#006060}
        .teal-background{background-color:#007d7d}
        .white{color:#bfbfbf}
        .white-background{background-color:#fafafa}
        .yellow{color:#bfbf00}
        .yellow-background{background-color:#fafa00}
        span.icon>.fa{cursor:default}
        a span.icon>.fa{cursor:inherit}
        .admonitionblock td.icon [class^="fa icon-"]{font-size:2.5em;text-shadow:1px 1px 2px rgba(0,0,0,.5);cursor:default}
        .admonitionblock td.icon .icon-note:before{content:"\f05a";color:#19407c}
        .admonitionblock td.icon .icon-tip:before{content:"\f0eb";text-shadow:1px 1px 2px rgba(155,155,0,.8);color:#111}
        .admonitionblock td.icon .icon-warning:before{content:"\f071";color:#bf6900}
        .admonitionblock td.icon .icon-caution:before{content:"\f06d";color:#bf3400}
        .admonitionblock td.icon .icon-important:before{content:"\f06a";color:#bf0000}
        .conum[data-value]{display:inline-block;color:#fff!important;background-color:rgba(0,0,0,.8);-webkit-border-radius:100px;border-radius:100px;text-align:center;font-size:.75em;width:1.67em;height:1.67em;line-height:1.67em;font-family:"Open Sans","DejaVu Sans",sans-serif;font-style:normal;font-weight:bold}
        .conum[data-value] *{color:#fff!important}
        .conum[data-value]+b{display:none}
        .conum[data-value]:after{content:attr(data-value)}
        pre .conum[data-value]{position:relative;top:-.125em}
        b.conum *{color:inherit!important}
        .conum:not([data-value]):empty{display:none}
        dt,th.tableblock,td.content,div.footnote{text-rendering:optimizeLegibility}
        h1,h2,p,td.content,span.alt{letter-spacing:-.01em}
        p strong,td.content strong,div.footnote strong{letter-spacing:-.005em}
        p,blockquote,dt,td.content,span.alt{font-size:1.0625rem}
        p{margin-bottom:1.25rem}
        .sidebarblock p,.sidebarblock dt,.sidebarblock td.content,p.tableblock{font-size:1em}
        .exampleblock>.content{background-color:#fffef7;border-color:#e0e0dc;-webkit-box-shadow:0 1px 4px #e0e0dc;box-shadow:0 1px 4px #e0e0dc}
        .print-only{display:none!important}
        @media print{@page{margin:1.25cm .75cm}
            *{-webkit-box-shadow:none!important;box-shadow:none!important;text-shadow:none!important}
            a{color:inherit!important;text-decoration:underline!important}
            a.bare,a[href^="#"],a[href^="mailto:"]{text-decoration:none!important}
            a[href^="http:"]:not(.bare):after,a[href^="https:"]:not(.bare):after{content:"(" attr(href) ")";display:inline-block;font-size:.875em;padding-left:.25em}
            abbr[title]:after{content:" (" attr(title) ")"}
            pre,blockquote,tr,img,object,svg{page-break-inside:avoid}
            thead{display:table-header-group}
            svg{max-width:100%}
            p,blockquote,dt,td.content{font-size:1em;orphans:3;widows:3}
            h2,h3,#toctitle,.sidebarblock>.content>.title{page-break-after:avoid}
            #toc,.sidebarblock,.exampleblock>.content{background:none!important}
            #toc{border-bottom:1px solid #ddddd8!important;padding-bottom:0!important}
            .sect1{padding-bottom:0!important}
            .sect1+.sect1{border:0!important}
            #header>h1:first-child{margin-top:1.25rem}
            body.book #header{text-align:center}
            body.book #header>h1:first-child{border:0!important;margin:2.5em 0 1em 0}
            body.book #header .details{border:0!important;display:block;padding:0!important}
            body.book #header .details span:first-child{margin-left:0!important}
            body.book #header .details br{display:block}
            body.book #header .details br+span:before{content:none!important}
            body.book #toc{border:0!important;text-align:left!important;padding:0!important;margin:0!important}
            body.book #toc,body.book #preamble,body.book h1.sect0,body.book .sect1>h2{page-break-before:always}
            .listingblock code[data-lang]:before{display:block}
            #footer{background:none!important;padding:0 .9375em}
            #footer-text{color:rgba(0,0,0,.6)!important;font-size:.9em}
            .hide-on-print{display:none!important}
            .print-only{display:block!important}
            .hide-for-print{display:none!important}
            .show-for-print{display:inherit!important}}
    </style>
</head>
<body class="book toc2 toc-left">
<div id="header">
    <h1>Greeting REST Service API Guide</h1>
    <div id="toc" class="toc2">
        <div id="toctitle">Table of Contents</div>
        <ul class="sectlevel1">
            <li><a href="#_userprofilerestcontroller">1. UserProfileRestController</a>
                <ul class="sectlevel2">
                    <li><a href="#_check_if_a_user_is_logged_in">1.1. Check if a User is logged in</a></li>
                    <li><a href="#_register_new_user">1.2. Register new User</a></li>
                </ul>
            </li>
            <li><a href="#_adminrestcontroller">2. AdminRestController</a>
                <ul class="sectlevel2">
                    <li><a href="#_get_list_of_all_users">2.1. Get list of all Users</a></li>
                    <li><a href="#_get_user_by_userid">2.2. Get User by userID</a></li>
                    <li><a href="#_create_new_user">2.3. Create new User</a></li>
                    <li><a href="#_delete_user">2.4. Delete User</a></li>
                </ul>
            </li>
            <li><a href="#_userrestaurantsrestcontroller">3. UserRestaurantsRestController</a>
                <ul class="sectlevel2">
                    <li><a href="#_create_new_restaurant">3.1. Create new Restaurant</a></li>
                    <li><a href="#_delete_restaurant">3.2. Delete Restaurant</a></li>
                    <li><a href="#_get_all_restaurants_with_likes_of_the_logged_in_user">3.3. Get all Restaurants with likes of the logged-in User</a></li>
                </ul>
            </li>
            <li><a href="#_adminrestaurantsrestcontroller">4. AdminRestaurantsRestController</a>
                <ul class="sectlevel2">
                    <li><a href="#_get_all_restaurants_of_all_users">4.1. Get all Restaurants (of all users)</a></li>
                    <li><a href="#_get_restaurant_by_its_id">4.2. Get Restaurant by its ID</a></li>
                    <li><a href="#_create_new_restaurant_2">4.3. Create new Restaurant</a></li>
                    <li><a href="#_delete_restaurant_2">4.4. Delete Restaurant</a></li>
                    <li><a href="#_get_all_restaurants_of_a_user">4.5. Get all Restaurants of a User</a></li>
                </ul>
            </li>
            <li><a href="#_usermenurestcontroller">5. UserMenuRestController</a>
                <ul class="sectlevel2">
                    <li><a href="#_get_all_menus">5.1. Get all Menus</a></li>
                    <li><a href="#_get_all_menus_with_likes">5.2. Get all Menus with Likes</a></li>
                    <li><a href="#_get_menu_by_id">5.3. Get Menu by ID</a></li>
                    <li><a href="#_create_new_menu_or_update_menu">5.4. Create new Menu (or update Menu)</a></li>
                    <li><a href="#_delete_menu">5.5. Delete Menu</a></li>
                    <li><a href="#_get_all_menus_by_restaurant_id">5.6. Get all Menus by Restaurant ID</a></li>
                    <li><a href="#_get_all_menus_by_restaurant_id_with_likes">5.7. Get all Menus by Restaurant ID with Likes</a></li>
                </ul>
            </li>
            <li><a href="#_adminmenurestcontroller">6. AdminMenuRestController</a>
                <ul class="sectlevel2">
                    <li><a href="#_get_all_menus_2">6.1. Get all Menus</a></li>
                    <li><a href="#_get_all_menus_with_likes_2">6.2. Get all Menus with Likes</a></li>
                    <li><a href="#_get_menu_by_its_id">6.3. Get Menu by its ID</a></li>
                    <li><a href="#_create_save_or_update_menu">6.4. Create (Save or Update) Menu</a></li>
                    <li><a href="#_delete_menu_2">6.5. Delete Menu</a></li>
                    <li><a href="#_get_menu_by_restaurant_id">6.6. Get Menu by Restaurant ID</a></li>
                    <li><a href="#_get_menu_by_restaurant_id_with_likes">6.7. Get Menu by Restaurant ID with Likes</a></li>
                </ul>
            </li>
            <li><a href="#_likerestcontroller">7. LikeRestController</a>
                <ul class="sectlevel2">
                    <li><a href="#_get_all_likes_by_menu_id">7.1. Get all Likes by Menu ID</a></li>
                    <li><a href="#_get_all_likes_by_restaurant_id">7.2. Get all Likes by Restaurant ID</a></li>
                    <li><a href="#_save_create_like_of_menu">7.3. Save/Create Like of Menu</a></li>
                    <li><a href="#_save_create_like_of_restaurant">7.4. Save/Create Like of Restaurant</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<div id="content">
    <div id="preamble">
        <div class="sectionbody">
            <div class="paragraph">
                <p>This is an example output for a service running at <a href="http://localhost:8080/lunchplacepicker/" class="bare">http://localhost:8080/lunchplacepicker/</a></p>
            </div>
        </div>
    </div>
    <div class="sect1">
        <h2 id="_userprofilerestcontroller">1. UserProfileRestController</h2>
        <div class="sectionbody">
            <div class="sect2">
                <h3 id="_check_if_a_user_is_logged_in">1.1. Check if a User is logged in</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/ifloggedin' -i -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 5

false</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_register_new_user">1.2. Register new User</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
<pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/register' -i -X POST \
    -H 'Content-Type: application/json' \
    -d '{
  "name" : "NewUser",
  "email" : "newuser@gmail.com",
  "registered" : "2021-01-05T23:00:00",
  "roles" : [ "USER" ]
}'</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 201 Created
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY</code></pre>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="sect1">
        <h2 id="_adminrestcontroller">2. AdminRestController</h2>
        <div class="sectionbody">
            <div class="sect2">
                <h3 id="_get_list_of_all_users">2.1. Get list of all Users</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/admin/users' -i -u 'admin@gmail.com:admin' -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 343

[ {
  "id" : 100001,
  "name" : "Admin",
  "email" : "admin@gmail.com",
  "registered" : "2018-11-25T19:00:00",
  "roles" : [ "USER", "ADMIN" ],
  "restaurants" : null
}, {
  "id" : 100000,
  "name" : "User",
  "email" : "user@gmail.com",
  "registered" : "2020-03-30T17:00:00",
  "roles" : [ "USER" ],
  "restaurants" : null
} ]</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_get_user_by_userid">2.2. Get User by userID</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/admin/users/100000' -i -u 'admin@gmail.com:admin' -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 163

{
  "id" : 100000,
  "name" : "User",
  "email" : "user@gmail.com",
  "registered" : "2020-03-30T17:00:00",
  "roles" : [ "USER" ],
  "restaurants" : null
}</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_create_new_user">2.3. Create new User</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
<pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/admin/users/' -i -u 'admin@gmail.com:admin' -X POST \
    -H 'Content-Type: application/json' \
    -d '{
  "name" : "NewUser",
  "email" : "newuser@gmail.com",
  "registered" : "2021-01-05T23:00:00",
  "roles" : [ "USER" ]
}'</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 201 Created
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_delete_user">2.4. Delete User</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
<pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/admin/users/100000' -i -u 'admin@gmail.com:admin' -X DELETE \
    -H 'Content-Type: application/json'</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 204 No Content
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY</code></pre>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="sect1">
        <h2 id="_userrestaurantsrestcontroller">3. UserRestaurantsRestController</h2>
        <div class="sectionbody">
            <div class="sect2">
                <h3 id="_create_new_restaurant">3.1. Create new Restaurant</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
<pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/profile/restaurants/all' -i -u 'user@gmail.com:user' -X POST \
    -H 'Content-Type: application/json' \
    -d '{
  "name" : "New Restaur",
  "address" : "new Place",
  "registerDateTime" : "2021-01-05T15:00:00",
  "description" : "Food",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg"
}'</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 201 Created
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_delete_restaurant">3.2. Delete Restaurant</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
<pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/profile/restaurants/all/100006' -i -u 'user@gmail.com:user' -X DELETE \
    -H 'Content-Type: application/json'</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 204 No Content
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_get_all_restaurants_with_likes_of_the_logged_in_user">3.3. Get all Restaurants with likes of the logged-in User</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/profile/restaurants/all/likes' -i -u 'admin@gmail.com:admin' -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 1424

[ {
  "id" : 100002,
  "name" : "Chez Marlene",
  "address" : "58 avenue de Paris",
  "registerDateTime" : "2020-03-30T10:00:00",
  "description" : "French Cuisine",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : [ ]
}, {
  "id" : 100003,
  "name" : "Chez Antoine",
  "address" : "93 rue de Versailles",
  "registerDateTime" : "2018-05-28T11:00:00",
  "description" : "Creperie",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : [ ]
}, {
  "id" : 100007,
  "name" : "La Table du 11",
  "address" : "8 Rue de la Chancellerie",
  "registerDateTime" : "2017-05-13T15:00:00",
  "description" : "French Cuisine",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : [ ]
}, {
  "id" : 100008,
  "name" : "Chez Tiouiche",
  "address" : "4 Rue Saint-Julien",
  "registerDateTime" : "2018-05-28T16:00:00",
  "description" : "Creperie",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : [ ]
}, {
  "id" : 100009,
  "name" : "Cheval Rouge",
  "address" : "Place de la Loi",
  "registerDateTime" : "2020-11-15T17:00:00",
  "description" : "English Cuisine",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : [ ]
} ]</code></pre>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="sect1">
        <h2 id="_adminrestaurantsrestcontroller">4. AdminRestaurantsRestController</h2>
        <div class="sectionbody">
            <div class="sect2">
                <h3 id="_get_all_restaurants_of_all_users">4.1. Get all Restaurants (of all users)</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/admin/rs/all' -i -u 'admin@gmail.com:admin' -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 2295

[ {
  "id" : 100002,
  "name" : "Chez Marlene",
  "address" : "58 avenue de Paris",
  "registerDateTime" : "2020-03-30T10:00:00",
  "description" : "French Cuisine",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : null
}, {
  "id" : 100003,
  "name" : "Chez Antoine",
  "address" : "93 rue de Versailles",
  "registerDateTime" : "2018-05-28T11:00:00",
  "description" : "Creperie",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : null
}, {
  "id" : 100004,
  "name" : "La Belle Epoque",
  "address" : "10 Place de la Mairie",
  "registerDateTime" : "2017-03-28T12:00:00",
  "description" : "French Cuisine",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : null
}, {
  "id" : 100005,
  "name" : "La Veranda",
  "address" : "1 Boulevard de la Reine",
  "registerDateTime" : "2016-05-28T13:00:00",
  "description" : "European Cuisine",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : null
}, {
  "id" : 100006,
  "name" : "Le Sept",
  "address" : "7 Rue de Montreuil",
  "registerDateTime" : "2015-05-27T14:00:00",
  "description" : "European Cuisine",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : null
}, {
  "id" : 100007,
  "name" : "La Table du 11",
  "address" : "8 Rue de la Chancellerie",
  "registerDateTime" : "2017-05-13T15:00:00",
  "description" : "French Cuisine",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : null
}, {
  "id" : 100008,
  "name" : "Chez Tiouiche",
  "address" : "4 Rue Saint-Julien",
  "registerDateTime" : "2018-05-28T16:00:00",
  "description" : "Creperie",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : null
}, {
  "id" : 100009,
  "name" : "Cheval Rouge",
  "address" : "Place de la Loi",
  "registerDateTime" : "2020-11-15T17:00:00",
  "description" : "English Cuisine",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : null
} ]</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_get_restaurant_by_its_id">4.2. Get Restaurant by its ID</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/admin/100001/100007' -i -u 'admin@gmail.com:admin' -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 292

{
  "id" : 100007,
  "name" : "La Table du 11",
  "address" : "8 Rue de la Chancellerie",
  "registerDateTime" : "2017-05-13T15:00:00",
  "description" : "French Cuisine",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : null
}</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_create_new_restaurant_2">4.3. Create new Restaurant</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
<pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/admin/100001' -i -u 'admin@gmail.com:admin' -X POST \
    -H 'Content-Type: application/json' \
    -d '{
  "name" : "New Restaur",
  "address" : "new Place",
  "registerDateTime" : "2021-01-05T15:00:00",
  "description" : "Food",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg"
}'</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 201 Created
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_delete_restaurant_2">4.4. Delete Restaurant</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
<pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/admin/100001/100007' -i -u 'admin@gmail.com:admin' -X DELETE \
    -H 'Content-Type: application/json'</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 204 No Content
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_get_all_restaurants_of_a_user">4.5. Get all Restaurants of a User</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/admin/100001/all' -i -u 'admin@gmail.com:admin' -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 1429

[ {
  "id" : 100002,
  "name" : "Chez Marlene",
  "address" : "58 avenue de Paris",
  "registerDateTime" : "2020-03-30T10:00:00",
  "description" : "French Cuisine",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : null
}, {
  "id" : 100003,
  "name" : "Chez Antoine",
  "address" : "93 rue de Versailles",
  "registerDateTime" : "2018-05-28T11:00:00",
  "description" : "Creperie",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : null
}, {
  "id" : 100007,
  "name" : "La Table du 11",
  "address" : "8 Rue de la Chancellerie",
  "registerDateTime" : "2017-05-13T15:00:00",
  "description" : "French Cuisine",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : null
}, {
  "id" : 100008,
  "name" : "Chez Tiouiche",
  "address" : "4 Rue Saint-Julien",
  "registerDateTime" : "2018-05-28T16:00:00",
  "description" : "Creperie",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : null
}, {
  "id" : 100009,
  "name" : "Cheval Rouge",
  "address" : "Place de la Loi",
  "registerDateTime" : "2020-11-15T17:00:00",
  "description" : "English Cuisine",
  "imgUrl" : "resources/images/placeholder_restaurant_pic.jpg",
  "menu" : null,
  "likesOfRestaurant" : null
} ]</code></pre>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="sect1">
        <h2 id="_usermenurestcontroller">5. UserMenuRestController</h2>
        <div class="sectionbody">
            <div class="sect2">
                <h3 id="_get_all_menus">5.1. Get all Menus</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/profile/menus/' -i -u 'user@gmail.com:user' -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 1545

[ {
  "id" : 100010,
  "description" : "French Lunch Menu",
  "creationDateTime" : "2020-03-30T12:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100011,
  "description" : "Crepes",
  "creationDateTime" : "2020-03-30T17:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100012,
  "description" : "English Lunch Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100013,
  "description" : "English Breakfast Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100014,
  "description" : "French Lunch Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100015,
  "description" : "English Dinner Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100016,
  "description" : "English Breakfast Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100017,
  "description" : "Crepes",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
} ]</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_get_all_menus_with_likes">5.2. Get all Menus with Likes</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/profile/menus/likes' -i -u 'user@gmail.com:user' -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 1735

[ {
  "id" : 100011,
  "description" : "Crepes",
  "creationDateTime" : "2020-03-30T17:00:00",
  "likesOfMenu" : [ ],
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100014,
  "description" : "French Lunch Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : [ ],
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100013,
  "description" : "English Breakfast Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : [ ],
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100010,
  "description" : "French Lunch Menu",
  "creationDateTime" : "2020-03-30T12:00:00",
  "likesOfMenu" : [ {
    "id" : 100018,
    "creationDateTime" : "2021-05-01T07:00:00",
    "userID" : 100000
  } ],
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100012,
  "description" : "English Lunch Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : [ ],
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100015,
  "description" : "English Dinner Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : [ ],
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100017,
  "description" : "Crepes",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : [ {
    "id" : 100019,
    "creationDateTime" : "2021-05-01T08:00:00",
    "userID" : 100001
  } ],
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100016,
  "description" : "English Breakfast Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : [ ],
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
} ]</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_get_menu_by_id">5.3. Get Menu by ID</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/profile/menus/100010' -i -u 'user@gmail.com:user' -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 192

{
  "id" : 100010,
  "description" : "French Lunch Menu",
  "creationDateTime" : "2020-03-30T12:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_create_new_menu_or_update_menu">5.4. Create new Menu (or update Menu)</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
<pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/profile/menus/100006' -i -u 'user@gmail.com:user' -X POST \
    -H 'Content-Type: application/json' \
    -d '{
  "description" : "New Lunch Menu",
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}'</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 201 Created
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_delete_menu">5.5. Delete Menu</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
<pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/profile/menus/100010' -i -u 'user@gmail.com:user' -X DELETE \
    -H 'Content-Type: application/json'</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 204 No Content
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_get_all_menus_by_restaurant_id">5.6. Get all Menus by Restaurant ID</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/profile/menus/100002/all' -i -u 'user@gmail.com:user' -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 196

[ {
  "id" : 100010,
  "description" : "French Lunch Menu",
  "creationDateTime" : "2020-03-30T12:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
} ]</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_get_all_menus_by_restaurant_id_with_likes">5.7. Get all Menus by Restaurant ID with Likes</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/profile/menus/100002/all/likes' -i -u 'user@gmail.com:user' -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 294

[ {
  "id" : 100010,
  "description" : "French Lunch Menu",
  "creationDateTime" : "2020-03-30T12:00:00",
  "likesOfMenu" : [ {
    "id" : 100018,
    "creationDateTime" : "2021-05-01T07:00:00",
    "userID" : 100000
  } ],
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
} ]</code></pre>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="sect1">
        <h2 id="_adminmenurestcontroller">6. AdminMenuRestController</h2>
        <div class="sectionbody">
            <div class="sect2">
                <h3 id="_get_all_menus_2">6.1. Get all Menus</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/admin/menus/' -i -u 'admin@gmail.com:admin' -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 1545

[ {
  "id" : 100010,
  "description" : "French Lunch Menu",
  "creationDateTime" : "2020-03-30T12:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100011,
  "description" : "Crepes",
  "creationDateTime" : "2020-03-30T17:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100012,
  "description" : "English Lunch Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100013,
  "description" : "English Breakfast Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100014,
  "description" : "French Lunch Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100015,
  "description" : "English Dinner Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100016,
  "description" : "English Breakfast Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100017,
  "description" : "Crepes",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
} ]</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_get_all_menus_with_likes_2">6.2. Get all Menus with Likes</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/admin/menus/likes' -i -u 'admin@gmail.com:admin' -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 1735

[ {
  "id" : 100011,
  "description" : "Crepes",
  "creationDateTime" : "2020-03-30T17:00:00",
  "likesOfMenu" : [ ],
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100014,
  "description" : "French Lunch Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : [ ],
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100013,
  "description" : "English Breakfast Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : [ ],
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100010,
  "description" : "French Lunch Menu",
  "creationDateTime" : "2020-03-30T12:00:00",
  "likesOfMenu" : [ {
    "id" : 100018,
    "creationDateTime" : "2021-05-01T07:00:00",
    "userID" : 100000
  } ],
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100012,
  "description" : "English Lunch Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : [ ],
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100015,
  "description" : "English Dinner Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : [ ],
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100017,
  "description" : "Crepes",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : [ {
    "id" : 100019,
    "creationDateTime" : "2021-05-01T08:00:00",
    "userID" : 100001
  } ],
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}, {
  "id" : 100016,
  "description" : "English Breakfast Menu",
  "creationDateTime" : "2020-03-30T10:00:00",
  "likesOfMenu" : [ ],
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
} ]</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_get_menu_by_its_id">6.3. Get Menu by its ID</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/admin/menus/100010' -i -u 'admin@gmail.com:admin' -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 192

{
  "id" : 100010,
  "description" : "French Lunch Menu",
  "creationDateTime" : "2020-03-30T12:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_create_save_or_update_menu">6.4. Create (Save or Update) Menu</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
<pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/admin/menus/100006' -i -u 'admin@gmail.com:admin' -X POST \
    -H 'Content-Type: application/json' \
    -d '{
  "description" : "New Lunch Menu",
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
}'</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 201 Created
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_delete_menu_2">6.5. Delete Menu</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
<pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/admin/menus/100010' -i -u 'admin@gmail.com:admin' -X DELETE \
    -H 'Content-Type: application/json'</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 204 No Content
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_get_menu_by_restaurant_id">6.6. Get Menu by Restaurant ID</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/admin/menus/100002/all' -i -u 'admin@gmail.com:admin' -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 196

[ {
  "id" : 100010,
  "description" : "French Lunch Menu",
  "creationDateTime" : "2020-03-30T12:00:00",
  "likesOfMenu" : null,
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
} ]</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_get_menu_by_restaurant_id_with_likes">6.7. Get Menu by Restaurant ID with Likes</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/admin/menus/100002/all/likes' -i -u 'admin@gmail.com:admin' -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 294

[ {
  "id" : 100010,
  "description" : "French Lunch Menu",
  "creationDateTime" : "2020-03-30T12:00:00",
  "likesOfMenu" : [ {
    "id" : 100018,
    "creationDateTime" : "2021-05-01T07:00:00",
    "userID" : 100000
  } ],
  "imgUrl" : "resources/images/placeholder_menu_pic.jpg"
} ]</code></pre>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="sect1">
        <h2 id="_likerestcontroller">7. LikeRestController</h2>
        <div class="sectionbody">
            <div class="sect2">
                <h3 id="_get_all_likes_by_menu_id">7.1. Get all Likes by Menu ID</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/likes/menu/100010' -i -u 'admin@gmail.com:admin' -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 94

[ {
  "id" : 100018,
  "creationDateTime" : "2021-05-01T07:00:00",
  "userID" : 100000
} ]</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_get_all_likes_by_restaurant_id">7.2. Get all Likes by Restaurant ID</h3>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
                        <pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/likes/restaurant/100005' -i -u 'admin@gmail.com:admin' -X GET</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 94

[ {
  "id" : 100020,
  "creationDateTime" : "2021-05-01T07:00:00",
  "userID" : 100001
} ]</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_save_create_like_of_menu">7.3. Save/Create Like of Menu</h3>
                <div class="admonitionblock note">
                    <table>
                        <tr>
                            <td class="icon">
                                <div class="title">Note</div>
                            </td>
                            <td class="content">
                                User can have (can create) only one unique like and if a User has already liked &lt;Menu A&gt; he/she can
                                remove this Like or like &lt;Menu B&gt; only before 11:00 AM.
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
<pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/likes/menu/100015' -i -u 'admin@gmail.com:admin' -X POST \
    -H 'Content-Type: application/json' \
    -d '{
  "creationDateTime" : "2021-04-05T07:00:00"
}'</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Language: en
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY</code></pre>
                    </div>
                </div>
            </div>
            <div class="sect2">
                <h3 id="_save_create_like_of_restaurant">7.4. Save/Create Like of Restaurant</h3>
                <div class="admonitionblock note">
                    <table>
                        <tr>
                            <td class="icon">
                                <div class="title">Note</div>
                            </td>
                            <td class="content">
                                User can have (can create) only one unique like and if a User has already liked &lt;Restaurant A&gt; he/she can
                                remove this Like or like &lt;Restaurant B&gt; only before 11:00 AM.
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="listingblock">
                    <div class="title">request</div>
                    <div class="content">
<pre class="highlight"><code class="language-bash" data-lang="bash">$ curl 'http://localhost:8080/lunchplacepicker/rest/likes/restaurant/100006' -i -u 'admin@gmail.com:admin' -X POST \
    -H 'Content-Type: application/json' \
    -d '{
  "creationDateTime" : "2021-04-05T07:00:00"
}'</code></pre>
                    </div>
                </div>
                <div class="listingblock">
                    <div class="title">response</div>
                    <div class="content">
<pre class="highlight nowrap"><code class="language-http" data-lang="http">HTTP/1.1 200 OK
Content-Language: en
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY</code></pre>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="footer">
    <div id="footer-text">
        Last updated 2021-05-09 20:43:38 CEST
    </div>
</div>
</body>
</html>