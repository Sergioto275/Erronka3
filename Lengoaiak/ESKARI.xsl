<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:decimal-format name="euro" decimal-separator="," grouping-separator="."/>
<xsl:template match="eskaria">
<html>
    <head>
        <title>Eskaria <xsl:value-of select="@id"/></title>
        <link rel="stylesheet" href="css/styles.css"/>
    </head>

    <body>
        <header>
            <h1>Eskaria <xsl:value-of select="@id"/></h1>
            <p>
                <b>Data: </b> <xsl:value-of select="eskaera_data"/>
                <span>
                    <xsl:attribute name="class">
                        <xsl:choose>
                            <xsl:when test="egoera/@id=1">
                                bullet yellow-bullet
                            </xsl:when>
                            <xsl:when test="egoera/@id=2">
                                bullet red-bullet 
                            </xsl:when>
                            <xsl:when test="egoera/@id=3">
                                bullet green-bullet 
                            </xsl:when>
                        </xsl:choose>
                    </xsl:attribute>
                    <xsl:value-of select="egoera"/>
                </span> 
            </p>
        </header>
        <main>
            <div class="flex-container">
                <xsl:if test="saltzailea">
                    <div class="user employee shadow">
                        <p class= "header">Erabiltzailea</p>
                        <p>
                            <img src="images/{saltzailea/abatar}"/>
                            <span><xsl:value-of select="saltzailea/izena"/></span>
                            <span><xsl:value-of select="saltzailea/abizena"/></span>
                            <span class="text-muted">(<xsl:value-of select="saltzailea/emaila"/>)</span>
                        </p>
                    </div>
                </xsl:if>
                <div class="user customer shadow">
                    <p class= "header">Bezeroa</p>
                    <p>
                        <img src="images/{bezeroa/abatar}"/>
                        <span><xsl:value-of select="bezeroa/izena"/></span>
                        <span><xsl:value-of select="bezeroa/abizena"/></span>
                        <span class="text-muted">(<xsl:value-of select="bezeroa/emaila"/>)</span>
                    </p>
                </div>
            </div>
                <xsl:apply-templates select="lerroak"/>
            <div>

            </div>
        </main>
    </body>
</html>
</xsl:template>

<xsl:template match="lerroak">
    <h2>Lerroak</h2>
        <ul class="table-items">
            <li class="table-header">
                <div class="col col-name">Izena</div>
                <div class="col col-category">Kategoria</div>
                <div class="col col-price">Salneurria</div>
                <div class="col col-op"></div>
                <div class="col col-amount">Kopurua</div>
                <div class="col col-op"></div>
                <div class="col col-total">Total</div>
            </li>
            <xsl:for-each select="item">
                
                <xsl:sort select="produktua/izena" order="ascending"/>
                    <xsl:variable name="prezioa" select="produktua/salneurria"/>
                    <xsl:variable name="zenbat" select="kopurua"/> 
                     
                    <li class="table-row shadow">
                        <div class="col col-name"><xsl:value-of select="produktua/izena"/>
                            <span class="text-muted"><xsl:value-of select="produktua/deskribapena"/></span>
                        </div>
                        <div class="col col-category"><xsl:value-of select="produktua/kategoria"/></div>
                        <div class="col col-price"><xsl:value-of select="produktua/salneurria"/></div>
                        <div class="col col-op">x</div>
                        <div class="col col-amount"><xsl:value-of select="kopurua"/></div>
                        <div class="col col-op">=</div>
                        <div class="col col-total"><xsl:value-of select="format-number($prezioa * $zenbat, '#.###,00€', 'euro')"/></div>
                    </li>     
                
                
            </xsl:for-each>
            
        </ul>
</xsl:template>

</xsl:stylesheet>