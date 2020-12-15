# Service calculating documents page count.
Library name: page-counter-api
version: 1.0.0

Today implemented only for DOC, DOCX and PDF calculating.
Calculating output result on HTTP post method calculate-documents.
System events output to log file.

## /page-counter/api/v1/calculate-documents Example Request Body
{
  "documentPath": "D:\\docs"
}

## Example Response
{
  "documents": 8,
  "pages": 16
}
