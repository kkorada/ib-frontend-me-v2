<template>
    <div id="footer" class="footer">
        <div class="footer-content">                
		<ul class="footer-nav">
			<li>
				<a xmlns:content="http://purl.org/rss/1.0/modules/content" href="footer/disclaimer.html">
				Disclaimer
				</a>
			</li>
			<li>
				<a xmlns:content="http://purl.org/rss/1.0/modules/content" href="footer/privacy-statement.html">
				Privacy
				</a>
			</li>
			<li>
				<a xmlns:content="http://purl.org/rss/1.0/modules/content" href="footer/cookies.html">
				Cookies
				</a>
			</li>			
			<li>				
				<a xmlns:content="http://purl.org/rss/1.0/modules/content" href="footer/security-on-the-internet.html">
				Security
				</a>
			</li>
			<li>		
				<a xmlns:content="http://purl.org/rss/1.0/modules/content" href="footer/us-persons.html">
				US Persons
				</a>
			</li>
			<li>
				<a xmlns:content="http://purl.org/rss/1.0/modules/content" href="sitemap.html">
				Sitemap
				</a>
			</li>
		</ul>
	</div>
        <div class="row">
            <div class="col-md-6">

            </div>
            <div class="col-md-6">

            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./jhi-footer.component.ts">
</script>

<style scoped>
    .footer {
        background-color: #ecebec;
        width: 100%;
        margin-top: 24px;
    }
    .footer-content {
        max-width: 1320px;
        margin: auto;
        padding: 0 15px 34px;
        position: relative;
        display: flex;
        flex-flow: column;
    }
    .footer-nav {
        padding-bottom: 12px;
        order: 2;
    }
    @media screen and (min-width: 768px) {
        .footer-nav {
            padding-bottom: 24px;
        }
    }
    @media screen and (min-width: 992px) {
        .footer-nav {
            position: absolute;
            left: 27px;
            top: 39px;
            padding-top: 0;
        }
    }
    @media screen and (min-width: 992px) {
        .footer-content {
            display: block;
            height: 95px;
            padding: 0;
        }
    }
    .footer-nav li {
        display: inline-block;
        line-height: 14px;
        padding-right: 13px;
        margin: 0 9px 15px 0;
        border-right: 1px solid #009286;
    }
</style>
