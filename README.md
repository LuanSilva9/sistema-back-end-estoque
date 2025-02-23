# Sistema de Estoques (Documentação) 📦📦📦

## - Diagrama de classes: 
![Diagrama de Classes](docs/assets/estoque-diagrama-de-classes.png)

## - Regras de Negocio:

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
