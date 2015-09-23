<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>E-Worksheets</title>
</head>
<body>
<table id="invoice">
    <tr>
        <td colspan="6">
            <h1>Factuur</h1>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            ${properties.name}
        </td>
        <td colspan="2">
            Factuurnummer
        </td>
        <td colspan="2">
            ${properties.invoiceNumber}
        </td>
    </tr>
    <tr>
        <td colspan="2">
            ${properties.street} ${properties.streetNumber}
        </td>
        <td colspan="2">
            Factuurdatum
        </td>
        <td colspan="2">
            ${properties.invoiceDate?string["dd/MM/yyyy"]} <label class="note">- (dd/MM/yyyy)</label>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            ${properties.city}
        </td>
        <td colspan="2">
            KvK-nummer
        </td>
        <td colspan="2">
            ${properties.coc?string["#"]}
        </td>
    </tr>
    <tr>
        <td colspan="2">
            ${properties.postalcode}
        </td>
        <td colspan="2">
            BTW registratie
        </td>
        <td colspan="2">
            ${properties.vatNumber}
        </td>
    </tr>
    <tr>
        <td colspan="6">
            <h3>Beschrijving</h3>
        </td>
    </tr>
    <tr>
        <td colspan="6">
            ${properties.description}
        </td>
    </tr>
    <tr>
        <td colspan="6">&nbsp;</td>
    </tr>
    <tr>
        <th class="bold">Beschrijving</th>
        <th class="bold">Eenheden</th>
        <th class="bold">Tarief</th>
        <th class="bold">Netto</th>
        <th class="bold">BTW(21%)</th>
        <th class="bold">Bruto</th>
    </tr>
    <tr>
        <td colspan="6"><hr/></td>
    </tr>
    <tr>
        <td>${properties.endPeriod?string["dd/MM/yyyy"]} <label class="note">- (dd/MM/yyyy)</label><br/>Standaard Uurtarief</td>
        <td>${properties.units}</td>
        <td>${properties.fare?string["#.00"]}</td>
        <td>${properties.net?string["#.00"]}</td>
        <td>${properties.vat?string["#.00"]}</td>
        <td>${properties.gross?string["#.00"]}</td>
    </tr>
    <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td class="bold">Factuurtotaal</td>
        <td class="bold">${properties.net?string["#.00"]}</td>
        <td class="bold">${properties.vat?string["#.00"]}</td>
        <td class="bold">${properties.gross?string["#.00"]}</td>
    </tr>
    <tr>
        <td colspan="6"><hr/></td>
    </tr>
    <tr>
        <td colspan="5">&nbsp;</td>
        <td><h3>Totaal = ${properties.gross?string["#.00"]} EUR</h3></td>
    </tr>
    <tr>
        <td colspan="6">
            Bank: ${properties.bank}<br/>
            IBAN: ${properties.IBAN}<br/>
            BIC: ${properties.BIC}<br/>
            Factuur te betalen in overeenstemming met de overeenkomst.
        </td>
    </tr>
</table>
</body>
</html>
