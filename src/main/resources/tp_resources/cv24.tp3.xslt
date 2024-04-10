<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0" xmlns:cv24="http://univ.fr/cv24">

  <xsl:template match="/cv24:cv24">
    <xsl:element name="html">
      <xsl:element name="head">
        <xsl:element name="title"><xsl:text>CV24 - XSLT V1.0</xsl:text>
        </xsl:element>
        <xsl:element name="link">
          <xsl:attribute name="rel">stylesheet</xsl:attribute>
          <xsl:attribute name="type">text/css</xsl:attribute>
          <xsl:attribute name="href">test.css</xsl:attribute>
        </xsl:element>
      </xsl:element>
      <xsl:element name="body">
        <xsl:element name="h1">CV24 - XSLT V1.0</xsl:element>
        <xsl:apply-templates select="cv24:identite"/>
        <xsl:apply-templates select="cv24:objectif"/>
        <xsl:apply-templates select="cv24:prof"/>
        <xsl:apply-templates select="cv24:competences"/>
        <xsl:apply-templates select="cv24:lv"/>
        <xsl:apply-templates select="cv24:divers"/>
      </xsl:element>
    </xsl:element>
  </xsl:template>
  
  <xsl:template match="cv24:identite">
  	<xsl:element name="h2">
  		<xsl:value-of select="cv24:genre"></xsl:value-of>
  		<xsl:text> </xsl:text>
  		<xsl:value-of select="cv24:nom"></xsl:value-of>
  		<xsl:text> </xsl:text>
  		<xsl:value-of select="cv24:prenom"></xsl:value-of>
  	</xsl:element>
  	<xsl:element name="p">
  		<xsl:text>Tel : </xsl:text>
  		<xsl:value-of select="cv24:tel"></xsl:value-of>
  		<xsl:element name="br"></xsl:element>
  		<xsl:text>Mel : </xsl:text>
  		<xsl:value-of select="cv24:mel"></xsl:value-of>
  	</xsl:element>
  </xsl:template>
  
  <xsl:template match="cv24:objectif">
  	<xsl:element name="h2">
  		<xsl:value-of select="text()"> </xsl:value-of>
  	</xsl:element>
  	<xsl:text>demande de </xsl:text><xsl:value-of select="@statut"></xsl:value-of>
  </xsl:template>
  
  <xsl:template match="cv24:prof">
  	<xsl:element name="h2">
  		<xsl:text>Expériences professionelles </xsl:text>
  	</xsl:element>
  	<xsl:element name="ol">
  		<xsl:apply-templates select="cv24:detail"/>
  	</xsl:element>
  </xsl:template>
  
  <xsl:template match="cv24:detail">
  	<xsl:element name="li">
  		<xsl:value-of select="cv24:titre"></xsl:value-of>
  		<xsl:text> (du </xsl:text>
  		<xsl:value-of select="cv24:datedeb"></xsl:value-of>
  		<xsl:text> au </xsl:text>
  		<xsl:value-of select="cv24:datefin"></xsl:value-of>
  		<xsl:text>)</xsl:text>
  	</xsl:element>
  </xsl:template>
  
  <xsl:template match="cv24:competences">
  	<xsl:element name="h2">
  		<xsl:text>Diplômes </xsl:text>
  	</xsl:element>
    <table border="0">
      <xsl:for-each select="cv24:diplome">
        <tr>
          <td><xsl:value-of select="cv24:date"/></td>
          <td><xsl:value-of select="cv24:titre"/></td>
          <td><xsl:text> (Niveau </xsl:text><xsl:value-of select="@niveau"/><xsl:text>)</xsl:text></td>
          <td><xsl:value-of select="cv24:institut"/></td>
        </tr>
      </xsl:for-each>
    </table>
    <xsl:element name="h2">
  		<xsl:text>Certifications </xsl:text>
  	</xsl:element>
    <table border="0">
      <xsl:for-each select="cv24:certif">
        <tr>
          <td><xsl:value-of select="cv24:datedeb"/><xsl:text> - </xsl:text><xsl:value-of select="cv24:datefin"/></td>
          <td><xsl:value-of select="cv24:titre"/></td>
        </tr>
      </xsl:for-each>
    </table>
  </xsl:template>
  
  <xsl:template match="cv24:divers">
  	<xsl:element name="h2">
  		<xsl:text>Langues </xsl:text>
  	</xsl:element>
  	<xsl:element name="ul">
  		<xsl:apply-templates select="cv24:lv"/>
  	</xsl:element>
    <xsl:element name="h2">
  		<xsl:text>Divers </xsl:text>
  	</xsl:element>
  	<xsl:element name="ul">
  		<xsl:apply-templates select="cv24:autre"/>
  	</xsl:element>
  </xsl:template>
  
  <xsl:template match="cv24:lv">
  	<xsl:element name="li">
  		<xsl:value-of select="@lang"></xsl:value-of>
  		<xsl:text> : </xsl:text>
  		<xsl:value-of select="@cert"></xsl:value-of>
  		<xsl:text> (</xsl:text>
  		<xsl:value-of select="@nivi | @nivs"></xsl:value-of>
  		<xsl:text>)</xsl:text>
  	</xsl:element>
  </xsl:template>

  <xsl:template match="cv24:autre">
  	<xsl:element name="li">
        <xsl:value-of select="@titre"/>
        <xsl:text>: </xsl:text>
        <xsl:value-of select="@comment"/>
    </xsl:element>
  </xsl:template>

</xsl:stylesheet>
