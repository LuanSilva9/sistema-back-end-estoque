# Sistema de Estoques (Documentação) 📦📦📦

## Diagrama de classes: 
![Diagrama de Classes](docs/assets/estoque-diagrama-de-classes.png)

## Regras de Negocio:

<table>
    <tr>
        <th>Regra de Negócio</th>
        <th>Descrição</th>
    </tr>
    <tr>
        <td>Produto Único por SKU</td>
        <td>Cada produto deve ter um SKU único para garantir identificação sem duplicação.</td>
    </tr>
    <tr>
        <td>Estoque Mínimo</td>
        <td>Cada produto no estoque deve ter uma quantidade mínima configurada, e quando o estoque atingir ou estiver abaixo desse valor, uma notificação será gerada.</td>
    </tr>
    <tr>
        <td>Controle de Lote</td>
        <td>Produtos devem ser armazenados com controle de lote e validade, permitindo rastrear a origem e validade dos mesmos.</td>
    </tr>
    <tr>
        <td>Entrada de Estoque</td>
        <td>Ao registrar uma entrada de estoque, o sistema deve associar a quantidade do produto, lote, validade (se aplicável) e o local do estoque.</td>
    </tr>
    <tr>
        <td>Saída de Estoque</td>
        <td>Ao registrar uma saída de estoque, o sistema deve subtrair a quantidade do produto correspondente, de acordo com o lote, e atualizar a quantidade disponível.</td>
    </tr>
    <tr>
        <td>Permissões de Acesso</td>
        <td>Os usuários têm permissões baseadas no perfil (ADMIN, OPERADOR, VISUALIZADOR), com restrições de acesso e manipulação de dados de estoque e movimentações.</td>
    </tr>
    <tr>
        <td>Relatórios de Movimentação</td>
        <td>O sistema gera relatórios automáticos sobre a movimentação de estoque, entradas e saídas, que podem ser exportados para análise.</td>
    </tr>
    <tr>
        <td>Produtos por Localização</td>
        <td>Produtos devem ser registrados com uma localização específica dentro do estoque (ex: prateleira, gaveta) para facilitar a gestão de espaço e organização.</td>
    </tr>
    <tr>
        <td>Limite de Estoque por Local</td>
        <td>Cada local de estoque pode ter um limite de capacidade para evitar sobrecarga e falta de espaço, sendo configurado conforme necessidade.</td>
    </tr>
</table>

## Endpoints Desejados:

<table border="1">
    <tr>
        <th>Endpoint</th>
        <th>Descrição</th>
        <th>Método HTTP</th>
        <th>Exemplo de Resposta</th>
    </tr>
    <tr>
        <td>/api/produtos</td>
        <td>Lista todos os produtos cadastrados no sistema.</td>
        <td>GET</td>
        <td>
            <pre><code>
[
    { "id": "1", "nome": "Teclado", "sku": "TK123", "precoVenda": 150.00 },
    { "id": "2", "nome": "Mouse", "sku": "MS456", "precoVenda": 80.00 }
]
            </code></pre>
        </td>
    </tr>
    <tr>
        <td>/api/produtos/{id}</td>
        <td>Detalha um produto específico.</td>
        <td>GET</td>
        <td>
            <pre><code>
{ 
    "id": "1", 
    "nome": "Teclado", 
    "descricao": "Teclado mecânico", 
    "sku": "TK123", 
    "precoVenda": 150.00 
}
            </code></pre>
        </td>
    </tr>
    <tr>
        <td>/api/produtos</td>
        <td>Cadastra um novo produto no sistema.</td>
        <td>POST</td>
        <td>
            <pre><code>
{ 
    "id": "1", 
    "nome": "Teclado", 
    "descricao": "Teclado mecânico", 
    "sku": "TK123", 
    "precoVenda": 150.00, 
    "categoriaId": "1" 
}
            </code></pre>
        </td>
    </tr>
    <tr>
        <td>/api/produtos/{id}</td>
        <td>Atualiza os dados de um produto existente.</td>
        <td>PUT</td>
        <td>
            <pre><code>
{ 
    "id": "1", 
    "nome": "Teclado", 
    "descricao": "Teclado mecânico RGB", 
    "sku": "TK123", 
    "precoVenda": 180.00 
}
            </code></pre>
        </td>
    </tr>
    <tr>
        <td>/api/produtos/{id}</td>
        <td>Deleta um produto do sistema.</td>
        <td>DELETE</td>
        <td>
            <pre><code>
{ "message": "Produto deletado com sucesso." }
            </code></pre>
        </td>
    </tr>
    <tr>
        <td>/api/estoque</td>
        <td>Lista todos os itens de estoque de uma empresa.</td>
        <td>GET</td>
        <td>
            <pre><code>
[
    { 
        "id": "1", 
        "produtoId": "1", 
        "quantidade": 100, 
        "localizacao": "Prateleira A3" 
    },
    { 
        "id": "2", 
        "produtoId": "2", 
        "quantidade": 50, 
        "localizacao": "Prateleira B1" 
    }
]
            </code></pre>
        </td>
    </tr>
    <tr>
        <td>/api/estoque</td>
        <td>Adiciona um item no estoque.</td>
        <td>POST</td>
        <td>
            <pre><code>
{ 
    "id": "1", 
    "produtoId": "1", 
    "quantidade": 50, 
    "localizacao": "Prateleira A3", 
    "validade": "2025-12-01" 
}
            </code></pre>
        </td>
    </tr>
    <tr>
        <td>/api/estoque/{id}</td>
        <td>Atualiza as informações de um item no estoque.</td>
        <td>PUT</td>
        <td>
            <pre><code>
{ 
    "id": "1", 
    "produtoId": "1", 
    "quantidade": 120, 
    "localizacao": "Prateleira A3" 
}
            </code></pre>
        </td>
    </tr>
    <tr>
        <td>/api/estoque/{id}</td>
        <td>Deleta um item do estoque.</td>
        <td>DELETE</td>
        <td>
            <pre><code>
{ "message": "Item removido do estoque." }
            </code></pre>
        </td>
    </tr>
    <tr>
        <td>/api/movimentacoes</td>
        <td>Lista todas as movimentações de estoque (entradas e saídas).</td>
        <td>GET</td>
        <td>
            <pre><code>
[
    { 
        "id": "1", 
        "produtoId": "1", 
        "quantidade": 10, 
        "tipo": "ENTRADA", 
        "data": "2025-02-23" 
    },
    { 
        "id": "2", 
        "produtoId": "2", 
        "quantidade": 5, 
        "tipo": "SAIDA", 
        "data": "2025-02-23" 
    }
]
            </code></pre>
        </td>
    </tr>
    <tr>
        <td>/api/movimentacoes</td>
        <td>Cadastra uma nova movimentação (entrada ou saída).</td>
        <td>POST</td>
        <td>
            <pre><code>
{ 
    "produtoId": "1", 
    "quantidade": 20, 
    "tipo": "SAIDA", 
    "motivo": "Venda", 
    "usuarioId": "2" 
}
            </code></pre>
        </td>
    </tr>
    <tr>
        <td>/api/movimentacoes/{id}</td>
        <td>Atualiza os dados de uma movimentação de estoque.</td>
        <td>PUT</td>
        <td>
            <pre><code>
{ 
    "produtoId": "1", 
    "quantidade": 15, 
    "tipo": "ENTRADA", 
    "motivo": "Reposição" 
}
            </code></pre>
        </td>
    </tr>
    <tr>
        <td>/api/movimentacoes/{id}</td>
        <td>Deleta uma movimentação de estoque.</td>
        <td>DELETE</td>
        <td>
            <pre><code>
{ "message": "Movimentação deletada com sucesso." }
            </code></pre>
        </td>
    </tr>
    <tr>
        <td>/api/fornecedores</td>
        <td>Lista todos os fornecedores registrados.</td>
        <td>GET</td>
        <td>
            <pre><code>
[
    { "id": "1", "nome": "Fornecedor A", "cnpj": "12345678000195" },
    { "id": "2", "nome": "Fornecedor B", "cnpj": "98765432000195" }
]
            </code></pre>
        </td>
    </tr>
    <tr>
        <td>/api/fornecedores</td>
        <td>Cadastra um novo fornecedor.</td>
        <td>POST</td>
        <td>
            <pre><code>
{ 
    "nome": "Fornecedor A", 
    "cnpj": "12345678000195", 
    "contato": "contato@fornecedora.com" 
}
            </code></pre>
        </td>
    </tr>
    <tr>
        <td>/api/fornecedores/{id}</td>
        <td>Detalha um fornecedor específico.</td>
        <td>GET</td>
        <td>
            <pre><code>
{ 
    "id": "1", 
    "nome": "Fornecedor A", 
    "cnpj": "12345678000195", 
    "contato": "contato@fornecedora.com" 
}
            </code></pre>
        </td>
    </tr>
    <tr>
        <td>/api/fornecedores/{id}</td>
        <td>Atualiza os dados de um fornecedor.</td>
        <td>PUT</td>
        <td>
            <pre><code>
{ 
    "nome": "Fornecedor A", 
    "cnpj": "12345678000195", 
    "contato": "novoemail@fornecedora.com" 
}
            </code></pre>
        </td>
    </tr>
    <tr>
        <td>/api/fornecedores/{id}</td>
        <td>Deleta um fornecedor do sistema.</td>
        <td>DELETE</td>
        <td>
            <pre><code>
{ "message": "Fornecedor deletado com sucesso." }
            </code></pre>
        </td>
    </tr>
</table>

