import java.io.OutputStream
import java.nio.charset.StandardCharsets
import java.time.{OffsetDateTime, ZoneOffset}
import java.time.format.DateTimeFormatter

import enums.Status

case class Response(
  status: Status,
  contentType: String,
  body: Array[Byte]
) {

  import Response._

  def writeTo(out: OutputStream): Unit = {
    val now = OffsetDateTime.now(ZoneOffset.UTC)
    val response =
      s"""HTTP/1.1 ${status.value}
         |Date: ${rfc1123Formatter.format(now)}
         |Server: SimpleScalaHttpServer
         |Content-Type: $contentType
         |Content-Length: ${body.length.toString}
         |Connection: Close
         |
         |""".stripMargin

    out.write(response.getBytes(StandardCharsets.UTF_8))
    out.write(body)
    out.flush()
  }
}

object Response {
  private val rfc1123Formatter = DateTimeFormatter.RFC_1123_DATE_TIME
}


