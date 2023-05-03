<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="bezeroak">
        <html>
            <head>
                <title>Bezeroak</title>
                <link rel="stylesheet" href="css/styles.css"/>
            </head>
            <body>
                <header>
                    <h1>Bezeroak</h1>
                </header>
                <main>
                    <xsl:for-each select="bezeroa">                     
                        <div class="user customer shadow">
                            <p class= "header">Bezeroa</p>
                            <p>
                            <img src="images/{bezeroa/abatar}"/>
                            <span><xsl:value-of select="bezeroa/izena"/></span>
                            <span><xsl:value-of select="bezeroa/abizena"/></span>
                            <span class="text-muted">(<xsl:value-of select="bezeroa/emaila"/>)</span>
                            </p>
                        </div>     
                    </xsl:for-each> 
                </main>
            </body>
            
        </html>
    </xsl:template>
</xsl:stylesheet>