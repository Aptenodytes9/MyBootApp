html {
  head {
    title ('Groovy Page')
    style ('''
      h1 {font-size:18pt; font-weight:bold; color:gray;}
      body {font-size:13pt; color:gray; margin:5px 25px;}
      tr {margin:5px;}
      th {padding:5px; color:white; background:darkgray;}
      td {padding:5px; color:black; background:#e0e0ff;}
    ''')
  }
  body{
    h1('Index Page')
    p(msg)
    table {
      tr {
        th('ID')
        th('NAME')
        th('MAIL')
      }
      data.each{obj ->
        tr{
            td(obj.id)
            td(obj.name)
            td(obj.value)
        }
      }
    }
  }
}
