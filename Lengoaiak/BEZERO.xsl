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
                                <img src="images/{abatar}"/>
                                <span><xsl:value-of select="izena"/></span>
                                <span><xsl:value-of select="abizena"/></span>
                                <span class="text-muted">(<xsl:value-of select="emaila"/>)</span>
                                <xsl:apply-templates select="telefonoak"/> 
                            </p>
                        </div>     
                    </xsl:for-each> 
                </main>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="telefonoak">
        <xsl:if test="zenbakia">
            <span><xsl:value-of select="zenbakia"/></span>
        </xsl:if>
    </xsl:template>
</xsl:stylesheet>